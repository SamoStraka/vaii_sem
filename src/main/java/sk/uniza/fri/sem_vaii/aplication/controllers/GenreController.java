package sk.uniza.fri.sem_vaii.aplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.fri.sem_vaii.aplication.repositories.GenreCrudRepository;
import sk.uniza.fri.sem_vaii.domain.Genre;

import java.util.Optional;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    GenreCrudRepository genreRepository;

    @GetMapping("{id}")
    Genre getGenre(@PathVariable Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        return genre.orElseThrow(RuntimeException::new);
    }

    @GetMapping()
    Iterable<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
