package eu.gzs.hotseat;

import eu.gzs.hotseat.controller.ClientController;
import eu.gzs.hotseat.daoclasses.ClientDAO;
import eu.gzs.hotseat.daoclasses.ClientDAOImpl;
import eu.gzs.hotseat.daoclasses.ClientService;
import eu.gzs.hotseat.model.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean
    @Scope("prototype")
    public Client client(){
        return new Client();
    }
    @Bean
    public ClientService clientService(){
        return new ClientService();
    }
    @Bean
    public ClientDAO clientDAOImpl(){
        return new ClientDAOImpl();
    }

}
