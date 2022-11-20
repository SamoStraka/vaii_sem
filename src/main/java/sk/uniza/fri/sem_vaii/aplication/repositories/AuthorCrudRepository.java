package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.uniza.fri.sem_vaii.domain.Author;

import java.util.List;

public interface AuthorCrudRepository extends CrudRepository<Author, Long> {
    List<Author> findByName(String name);
}
