package sk.uniza.fri.sem_vaii.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.fri.sem_vaii.aplication.repositories.AuthorCrudRepository;
import sk.uniza.fri.sem_vaii.domain.Author;

import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    AuthorCrudRepository authorCrudRepository;

    @GetMapping("{id}")
    Author getAuthor(@PathVariable Long id) {
        Optional<Author> author =authorCrudRepository.findById(id);
        return author.orElseThrow(RuntimeException::new);
    }

    @GetMapping()
    Iterable<Author> getAuthors() {
        return authorCrudRepository.findAll();
    }
}
