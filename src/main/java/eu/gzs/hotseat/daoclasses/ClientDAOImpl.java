package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.HibernateUtil;
import eu.gzs.hotseat.model.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    private Session currentSession;
    private Transaction currentTransaction;

    public ClientDAOImpl(){}

    @Override
    public Client save(Client client) {
        getCurrentSession().save(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        getCurrentSession().update(client);
        return client;
    }

    @Override
    public Client delete(Client client) {
        getCurrentSession().delete(client);
        return client;
    }

    @Override
    public void delete_all_clients() {
        List<Client> entityList = getAllClients();
        for (Client entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public Client findByClientId(int clientId) {
        return (Client) getCurrentSession().get(Client.class, clientId);
    }

    @Override
    public List<Client> getAllClients() {
        return (List<Client>) getCurrentSession().createQuery("from Client").list();
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
;

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
