package eu.gzs.hotseat;

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
}
