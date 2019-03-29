package eu.gzs.hotseat;

import eu.gzs.hotseat.controller.ClientController;
import eu.gzs.hotseat.daoclasses.*;
import eu.gzs.hotseat.model.Client;
import eu.gzs.hotseat.model.Seat;
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
    @Bean
    public MovieService movieService(){
        return new MovieService();
    }
    @Bean
    SeanceService seanceService(){
        return new SeanceService();
    }

}
