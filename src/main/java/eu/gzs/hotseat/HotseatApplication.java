package eu.gzs.hotseat;

import eu.gzs.hotseat.daoclasses.*;
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

		MovieService movieService=new MovieService();
		Movie movie1=new Movie("James Bond", 120);
		Movie movie2=new Movie("Mickey Mouse", 60);

		//movieService.save(movie1);
		//movieService.save(movie2);
		List<Movie> list_all_movies=movieService.getAllMovies();
		for(Movie m : list_all_movies){
			System.out.println(m.getName()+" "+m.getDuration());
		}

		movie1=movieService.findByMovieId(3);
		System.out.println(movie1.getName()+" "+movie1.getDuration());

		movie1.setName("Casino Royale");
		movieService.update(movie1);

		SeanceService seanceService=new SeanceService();
		Seance seance1=new Seance(movie1, 20);
		seanceService.save(seance1);

	}

}
