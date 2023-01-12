package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.fri.sem_vaii.domain.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByName(String name);
}
