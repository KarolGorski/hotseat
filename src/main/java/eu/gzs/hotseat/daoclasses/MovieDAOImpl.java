package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.HibernateUtil;
import eu.gzs.hotseat.model.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl extends HibernateDaoSupport implements MovieDAO {

    @Override
    public void save(Movie movie) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(movie);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public void update(Movie movie) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(movie);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public void delete(Movie movie) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(movie);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public Movie findByMovieId(int movieId) {
        Movie movie=null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            movie=session.load(Movie.class, movieId);
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> list=new ArrayList<>();
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            list=session.createQuery("from Movie").list();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
        return list;
    }
}
