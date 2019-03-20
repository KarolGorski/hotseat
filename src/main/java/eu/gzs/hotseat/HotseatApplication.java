package eu.gzs.hotseat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HotseatApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotseatApplication.class, args);
		//moj testowy komentarz git
		//moj lepszy testowy komentarz git

		//Stworzenie i otwarcie sesji z bazą
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//Tworzenie Person - tu bez bean'ów narazie, testowo
		Person person = new Person();
		person.setName("Karol"); person.setCountry("Poland");

		//zapis obiektu do bazy z automatycznym mapowaniem do tabeli
		session.save(person);
		session.getTransaction().commit();

		//odczyt z bazy z automatycznym mapowaniem do obiektu
		List<Person> personList = session.createQuery("from Person").list();

		for(Person p : personList){
			System.out.println(p.toString());
		}

		//zamkniecie sesji
		session.close();

	}

}
