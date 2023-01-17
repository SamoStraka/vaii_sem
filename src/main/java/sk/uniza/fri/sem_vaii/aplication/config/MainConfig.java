package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.*;

@Configuration
public class MainConfig {

    @Bean
    public AuthorAssembler authorAssembler() {return new AuthorAssembler();}

    @Bean
    public AwardAssembler awardAssembler() {return new AwardAssembler();}

    @Bean
    public BookAssembler bookAssembler() {return new BookAssembler();}

    @Bean
    ContactAssembler contactAssembler() {return new ContactAssembler();}

    @Bean
    public GenreAssembler genreAssembler() {return new GenreAssembler();}

    @Bean
    public LanguageAssembler languageAssembler() {return new LanguageAssembler();}

    @Bean
    public ReservationAssembler reservationAssembler() {return new ReservationAssembler();}

}
