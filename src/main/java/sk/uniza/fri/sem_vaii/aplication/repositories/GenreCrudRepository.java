package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.uniza.fri.sem_vaii.domain.Genre;

public interface GenreCrudRepository extends CrudRepository<Genre, Long> {
}
