package eu.gzs.hotseat.controller;



import eu.gzs.hotseat.daoclasses.ClientService;
import eu.gzs.hotseat.model.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/clients"})
public class ClientController {

    ClientService clientService = new ClientService();

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.save(client);

    }

    @PostMapping("/add/{name}")
    Client addClient(@PathVariable(value="name") String name) {
        Client c = new Client();
        c.setName(name);
        return clientService.save(c);
    }

    @GetMapping(path = {"/{id}"})
    public Client findByClientId(@PathVariable int id){
        return clientService.findByClientId(id);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping(value="/{id}")
    public Client update(@PathVariable("id") int id,
                        @RequestBody Client client){
        Client client_temp = findByClientId(id);
        client_temp.setName(client.getName());

        return clientService.update(client_temp);
    }

    @DeleteMapping(value = "/{id}")
    public Client delete(@PathVariable("id") int id){
        return clientService.delete(findByClientId(id));
    }
}
