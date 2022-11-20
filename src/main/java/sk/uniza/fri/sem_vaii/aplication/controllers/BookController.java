package sk.uniza.fri.sem_vaii.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.fri.sem_vaii.aplication.repositories.BookCrudRepository;
import sk.uniza.fri.sem_vaii.domain.Book;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookCrudRepository bookRepository;

    @GetMapping("{id}")
    Book getBook(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(RuntimeException::new);
    }

    @GetMapping()
    Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }
}
