package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.ReservationAssembler;

@Configuration
public class ReservationConfig {
    @Bean
    public ReservationAssembler reservationAssembler() {return new ReservationAssembler();}
}
