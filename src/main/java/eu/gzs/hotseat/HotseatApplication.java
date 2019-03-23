package eu.gzs.hotseat;

import eu.gzs.hotseat.daoclasses.MovieDAO;
import eu.gzs.hotseat.daoclasses.MovieDAOImpl;
import eu.gzs.hotseat.daoclasses.SeanceDAO;
import eu.gzs.hotseat.daoclasses.SeanceDAOImpl;
import eu.gzs.hotseat.model.Client;
import eu.gzs.hotseat.model.Movie;
import eu.gzs.hotseat.model.Seance;
import eu.gzs.hotseat.model.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class HotseatApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(HotseatApplication.class, args);

		//Stworzenie i otwarcie sesji z bazą
//		Configuration configuration=new Configuration();
//		configuration.configure("hibernate.cfg.xml")
//				.addAnnotatedClass(eu.gzs.hotseat.model.Seance.class)
//				.addAnnotatedClass(eu.gzs.hotseat.model.Seat.class)
//				.addAnnotatedClass(eu.gzs.hotseat.model.Movie.class)
//				.addAnnotatedClass(eu.gzs.hotseat.model.Client.class);
//		SessionFactory sessionFactory = configuration.buildSessionFactory();

		HibernateUtil.createSessionFactory();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Client client1=new Client("Karol Gorski");
		Movie movie1=new Movie("Star Wars", 180);
		Movie movie2=new Movie("Hobbit", 200);
		Seance seance1=new Seance(movie1, 50);
		seance1.getSeats().get(23).setClient(client1);

		MovieDAO movie_service=new MovieDAOImpl();
		movie_service.save(movie2);

		SeanceDAO seance_service=new SeanceDAOImpl();
		seance_service.save(new Seance(movie2, 30));

		session.save(client1);
		session.save(seance1);
		session.save(movie1);
		for(Seat seat : seance1.getSeats()){
			session.save(seat);
		}

		session.getTransaction().commit();

		//zamkniecie sesji
		session.close();

	}

}
