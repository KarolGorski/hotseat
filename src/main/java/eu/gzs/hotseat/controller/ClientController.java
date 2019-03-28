package eu.gzs.hotseat.controller;



import eu.gzs.hotseat.daoclasses.ClientService;
import eu.gzs.hotseat.model.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/clients"})
public class ClientController {

    ClientService clientService = new ClientService();

    @RequestMapping("/add/{name}")
    public @ResponseBody
    void addClient(@PathVariable(value="name") String name) {
        Client c = new Client();
        c.setName(name);
        clientService.save(c);
    }
}
