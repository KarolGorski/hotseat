package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Client;

import java.util.List;

public class ClientService {
    private static ClientDAOImpl clientDaoImpl;

    public ClientService() {
        clientDaoImpl=new ClientDAOImpl();
    }

    public Client save(Client client){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.save(client);
        clientDaoImpl.closeCurrentSessionwithTransaction();
        return client;
    }

    public Client update(Client client){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.update(client);
        clientDaoImpl.closeCurrentSessionwithTransaction();
        return client;
    }

    public Client delete(Client client){
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.delete(client);
        clientDaoImpl.closeCurrentSessionwithTransaction();
        return client;
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
