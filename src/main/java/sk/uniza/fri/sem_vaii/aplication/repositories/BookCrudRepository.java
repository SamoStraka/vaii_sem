package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.uniza.fri.sem_vaii.domain.Book;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
}
