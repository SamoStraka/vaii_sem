package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.GenreAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.GenreRepository;
import sk.uniza.fri.sem_vaii.aplication.services.GenreService;
import sk.uniza.fri.sem_vaii.domain.Genre;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping("{id}")
    GenreDTO getGenre(@PathVariable Long id) {
        Genre genre = genreService.getGenre(id);
        return GenreAssembler.toDto(genre);
    }

    @GetMapping()
    Iterable<GenreDTO> getGenres() {
        return genreService.getGenres().stream()
                .map(GenreAssembler::toDto).toList();
    }

    @PostMapping()
    GenreDTO newGenre(@Valid @RequestBody GenreDTO genreDTO) {
        if (genreService.getGenre(genreDTO.getId()) != null) {
            throw new RuntimeException();
        }

        return GenreAssembler.toDto(genreService.addGenre(genreDTO));
    }

    @DeleteMapping("{id}")
    void deleteAuthor(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}
