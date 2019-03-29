package eu.gzs.hotseat.controller;



import eu.gzs.hotseat.daoclasses.ClientService;
import eu.gzs.hotseat.model.Client;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/clients"})
public class ClientController implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    ClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.save(client);

    }

    @PostMapping("/add/{name}")
    Client addClient(@PathVariable(value="name") String name) {
        Client c=applicationContext.getBean(Client.class);
        //Client c = new Client();
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public void setClientService(ClientService clientService){
        this.clientService=clientService;
    }
}
