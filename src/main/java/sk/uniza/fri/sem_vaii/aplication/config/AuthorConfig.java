package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AuthorAssembler;

@Configuration
public class AuthorConfig {

    @Bean
    public AuthorAssembler authorAssembler() {return new AuthorAssembler();}
}
