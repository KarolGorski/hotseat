package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.HibernateUtil;
import eu.gzs.hotseat.model.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {

    private Session currentSession;
    private Transaction currentTransaction;

    public MovieDAOImpl(){};

    @Override
    public Movie save(Movie movie) {
        getCurrentSession().save(movie);
        return movie;
    }

    @Override
    public Movie update(Movie movie) {
        getCurrentSession().update(movie);
        return movie;
    }

    @Override
    public Movie delete(Movie movie) {
        getCurrentSession().delete(movie);
        return movie;
    }

    @Override
    public void delete_all_movies() {
        List<Movie> entityList = getAllMovies();
        for (Movie entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public Movie findByMovieId(int movieId) {
        return (Movie) getCurrentSession().get(Movie.class, movieId);
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) getCurrentSession().createQuery("from Movie").list();
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    private static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
