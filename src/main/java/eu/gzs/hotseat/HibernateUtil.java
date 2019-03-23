package eu.gzs.hotseat;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static void createSessionFactory() {
        if(sessionFactory==null) {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml")
                        .addAnnotatedClass(eu.gzs.hotseat.model.Seance.class)
                        .addAnnotatedClass(eu.gzs.hotseat.model.Seat.class)
                        .addAnnotatedClass(eu.gzs.hotseat.model.Movie.class)
                        .addAnnotatedClass(eu.gzs.hotseat.model.Client.class);
                sessionFactory=configuration.buildSessionFactory();
            } catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
