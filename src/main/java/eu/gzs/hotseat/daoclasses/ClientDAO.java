package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Client;

import java.util.List;

public interface ClientDAO {
    void save(Client client);

    void update(Client client);

    void delete(Client client);

    Client findByClientId(int clientId);

    List<Client> getAllClients();
}
