package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AwardAssembler;

@Configuration
public class AwardConfig {
    @Bean
    public AwardAssembler awardAssembler() {return new AwardAssembler();}
}
