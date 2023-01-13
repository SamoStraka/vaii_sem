package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.fri.sem_vaii.domain.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
