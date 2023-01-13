package sk.uniza.fri.sem_vaii.aplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.uniza.fri.sem_vaii.aplication.assemblers.LanguageAssembler;

@Configuration
public class LanguageConfig {
    @Bean
    public LanguageAssembler languageAssembler() {return new LanguageAssembler();}
}
