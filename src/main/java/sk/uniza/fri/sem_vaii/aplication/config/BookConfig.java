package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.BookAssembler;

@Configuration
public class BookConfig {
    @Bean
    public BookAssembler bookAssembler() {return new BookAssembler();}
}
