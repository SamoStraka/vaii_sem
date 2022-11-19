package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.uniza.fri.sem_vaii.domain.Author;

public interface AuthorCrudRepository extends CrudRepository<Author, Long> {
}
