package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.AuthorAssembler;
import sk.uniza.fri.sem_vaii.aplication.assemblers.BookAssembler;
import sk.uniza.fri.sem_vaii.aplication.assemblers.GenreAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.AuthorDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.BookDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.BookRepository;
import sk.uniza.fri.sem_vaii.aplication.services.AuthorService;
import sk.uniza.fri.sem_vaii.aplication.services.BookService;
import sk.uniza.fri.sem_vaii.aplication.services.GenreService;
import sk.uniza.fri.sem_vaii.domain.Book;
import sk.uniza.fri.sem_vaii.domain.Genre;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    @GetMapping("{id}/genres")
    Iterable<GenreDTO> getBookGenres(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        return book.getBookGenres().stream()
                .map(GenreAssembler::toDto).toList();
    }

    @GetMapping("{id}")
    BookDTO getBook(@PathVariable Long id) {
        Book book = bookService.getBook(id);
        return BookAssembler.toDto(book);
    }

    @GetMapping()
    Iterable<BookDTO> getBooks(@RequestParam(name="title", required = false)String title) {
        if (title == null || title.isBlank()) {
            return bookService.getBooks().stream()
                    .map(BookAssembler::toDto).toList();
        }

        return bookService.getBookByTitle(title).stream()
                .map(BookAssembler::toDto).toList();
    }
    @PostMapping()
    BookDTO newBook(@Valid @RequestBody BookDTO bookDTO) {
        if (bookService.getBook(bookDTO.getId()) != null) {
            throw new RuntimeException();
        }

        return BookAssembler.toDto(bookService.addBook(bookDTO));
    }

    @PutMapping("{id}")
    BookDTO replaceBook(@Valid @RequestBody BookDTO bookDTO, @PathVariable Long id) {
        return BookAssembler.toDto(bookService.updateBook(id, bookDTO));
    }

    @DeleteMapping("{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
