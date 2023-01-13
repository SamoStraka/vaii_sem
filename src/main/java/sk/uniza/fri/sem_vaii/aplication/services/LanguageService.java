package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.repositories.LanguageRepository;
import sk.uniza.fri.sem_vaii.domain.Language;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    public List<Language> getLanguages() {
        return languageRepository.findAll();
    }
}
