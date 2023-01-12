package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.fri.sem_vaii.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
