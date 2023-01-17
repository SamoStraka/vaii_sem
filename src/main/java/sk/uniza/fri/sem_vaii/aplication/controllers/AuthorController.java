package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AuthorAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.AuthorDTO;
import sk.uniza.fri.sem_vaii.aplication.services.AuthorService;
import sk.uniza.fri.sem_vaii.domain.Author;
import sk.uniza.fri.sem_vaii.domain.Book;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("{id}/books")
    Iterable<Book> getAuthorBooks(@PathVariable Long id) {
        Author author = authorService.getAuthor(id);
        return author.getAuthorBooks();
    }

    @GetMapping("{id}")
    AuthorDTO getAuthor(@PathVariable Long id) {
        return AuthorAssembler.toDto(authorService.getAuthor(id));
    }

    @GetMapping()
    Iterable<AuthorDTO> getAuthors(@RequestParam(name="name", required = false) String name) {
        if (name == null  || name.isBlank()) {
            return authorService.getAuthors().stream()
                    .map(AuthorAssembler::toDto).toList();
        }

        return authorService.getAuthorByName(name).stream()
                .map(AuthorAssembler::toDto).toList();
    }

    @PostMapping()
    ResponseEntity<AuthorDTO> newAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        if (authorService.getAuthor(authorDTO.getId()) != null) {
            throw new RuntimeException();
        }

    return new ResponseEntity<>(AuthorAssembler.toDto(authorService.addAuthor(authorDTO)), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    AuthorDTO replaceAuthor(@Valid @RequestBody AuthorDTO newAuthorDTO, @PathVariable Long id) {
        return AuthorAssembler.toDto(authorService.updateAuthor(id, newAuthorDTO));
    }

    @DeleteMapping("{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
