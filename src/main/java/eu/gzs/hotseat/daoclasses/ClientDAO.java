package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Client;

import java.util.List;

public interface ClientDAO {
    Client save(Client client);

    Client update(Client client);

    Client delete(Client client);

    void delete_all_clients();

    Client findByClientId(int clientId);

    List<Client> getAllClients();
}
