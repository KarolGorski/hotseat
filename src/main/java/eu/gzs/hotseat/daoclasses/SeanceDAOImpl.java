package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.HibernateUtil;
import eu.gzs.hotseat.model.Seance;
import eu.gzs.hotseat.model.Seat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class SeanceDAOImpl implements SeanceDAO {
    private Session currentSession;
    private Transaction currentTransaction;

    public SeanceDAOImpl(){};

    @Override
    public void save(Seance seance) {
        List<Seat> seats=seance.getSeats();
        for(Seat s : seats){
            getCurrentSession().save(s);
        }
        getCurrentSession().save(seance);
    }

    @Override
    public void update(Seance seance) {
        List<Seat> seats=seance.getSeats();
        for(Seat s : seats){
            getCurrentSession().update(s);
        }
        getCurrentSession().update(seance);
    }

    @Override
    public void delete(Seance seance) {
        getCurrentSession().delete(seance);
    }

    @Override
    public void delete_all_seances() {
        List<Seance> entityList = getAllSeances();
        for (Seance entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public Seance findBySeanceId(int seanceId) {
        return (Seance) getCurrentSession().get(Seance.class, seanceId);
    }

    @Override
    public Seance findByMovieId(int movieId) {
        return (Seance) getCurrentSession().createQuery("from Seance where movie_id="+movieId);
    }

    @Override
    public List<Seance> getAllSeances() {
        return (List<Seance>) getCurrentSession().createQuery("from Seance").list();
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
