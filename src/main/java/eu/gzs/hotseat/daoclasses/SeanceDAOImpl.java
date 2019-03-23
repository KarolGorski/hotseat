package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.HibernateUtil;
import eu.gzs.hotseat.model.Seance;
import eu.gzs.hotseat.model.Seat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class SeanceDAOImpl extends HibernateDaoSupport implements SeanceDAO {
    @Override
    public void save(Seance seance) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(seance);
            for(Seat s : seance.getSeats()){
                session.save(s);
            }
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public void update(Seance seance) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(seance);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public void delete(Seance seance) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(seance);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public Seance findBySeanceId(int senaceId) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            return session.load(Seance.class, senaceId);
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }

        return null;
    }

    @Override
    public Seance findByMovieId(int movieId) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            return (Seance) session.createCriteria(Seance.class)
                    .add(Restrictions.eq("movie_id", movieId)).uniqueResult();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Seance> getAllSeances() {
        List<Seance> list=new ArrayList<>();
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            list=session.createQuery("from Seance").list();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
        return list;
    }
}
