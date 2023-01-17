package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.ContactAssembler;

@Configuration
public class ContactConfig {
    @Bean
    ContactAssembler contactAssembler() {return new ContactAssembler();}
}
