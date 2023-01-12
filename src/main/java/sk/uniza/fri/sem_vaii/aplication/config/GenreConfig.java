package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.GenreAssembler;

@Configuration
public class GenreConfig {
    @Bean
    public GenreAssembler genreAssembler() {return new GenreAssembler();}
}
