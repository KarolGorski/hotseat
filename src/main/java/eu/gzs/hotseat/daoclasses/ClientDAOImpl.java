package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.HibernateUtil;
import eu.gzs.hotseat.model.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public void save(Client client) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public void delete(Client client) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
    }

    @Override
    public Client findByClientId(int clientId) {
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            return session.load(Client.class, clientId);
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> list=new ArrayList<>();
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            list=session.createQuery("from Client").list();
        }catch (HibernateException hibex){
            hibex.printStackTrace();
        }
        return list;
    }
}
