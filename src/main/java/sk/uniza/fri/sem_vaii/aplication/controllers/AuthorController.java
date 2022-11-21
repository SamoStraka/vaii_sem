package sk.uniza.fri.sem_vaii.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.repositories.AuthorCrudRepository;
import sk.uniza.fri.sem_vaii.domain.Author;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    AuthorCrudRepository authorCrudRepository;

    @GetMapping("{id}")
    Author getAuthor(@PathVariable Long id) {
        Optional<Author> author = authorCrudRepository.findById(id);
        return author.orElseThrow(RuntimeException::new);
    }

    @GetMapping()
    Iterable<Author> getAuthors(@RequestParam(name="name", required = false) String name) {
        if (name == null  || name.isBlank()) {
            return authorCrudRepository.findAll();
        } else {
            return authorCrudRepository.findByName(name);
        }
    }

    @PostMapping()
    Author newAuthor(@Valid @RequestBody Author author) {
        return authorCrudRepository.save(author);
    }

    @PutMapping("{id}")
    Author replaceAuthor(@Valid @RequestBody Author newAuthor, @PathVariable Long id) {
        return authorCrudRepository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    author.setLastName(newAuthor.getLastName());
                    author.setInfo(newAuthor.getInfo());
                    author.setAuthorBooks(newAuthor.getAuthorBooks());
                    return authorCrudRepository.save(author);
                })
                .orElseGet(() -> {
                    newAuthor.setId(id);
                    return  authorCrudRepository.save(newAuthor);
                });
    }

    @DeleteMapping("{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorCrudRepository.deleteById(id);
    }
}
