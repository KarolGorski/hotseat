package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Client;

import java.util.List;

public class ClientService {
    private static ClientDAOImpl clientDaoImpl;

    public ClientService() {
        clientDaoImpl=new ClientDAOImpl();
    }

    public void save(Client movie){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.save(movie);
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void update(Client movie){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.update(movie);
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void delete(Client movie){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.delete(movie);
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void delete_all(){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.delete_all_clients();
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public Client findByClientId(int clientId){
        clientDaoImpl.openCurrentSessionwithTransaction();
        Client client=clientDaoImpl.findByClientId(clientId);
        clientDaoImpl.closeCurrentSessionwithTransaction();
        return client;
    }

    public List<Client> getAllClients(){
        clientDaoImpl.openCurrentSessionwithTransaction();
        List<Client> clients=clientDaoImpl.getAllClients();
        clientDaoImpl.closeCurrentSessionwithTransaction();
        return clients;
    }
}
