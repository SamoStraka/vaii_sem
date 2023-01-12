package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.BookAssembler;
import sk.uniza.fri.sem_vaii.aplication.assemblers.GenreAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.BookDTO;
import sk.uniza.fri.sem_vaii.aplication.dtos.GenreDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.BookRepository;
import sk.uniza.fri.sem_vaii.aplication.services.BookService;
import sk.uniza.fri.sem_vaii.domain.Book;
import sk.uniza.fri.sem_vaii.domain.Genre;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

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
}
