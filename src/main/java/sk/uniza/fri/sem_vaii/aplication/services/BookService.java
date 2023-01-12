package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.assemblers.BookAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.BookDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.BookRepository;
import sk.uniza.fri.sem_vaii.domain.Book;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class BookService {
    private final BookAssembler bookAssembler;
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book addBook(BookDTO bookDTO) {
        var book = bookAssembler.fromDto(bookDTO);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookDTO bookDTO) {
        var updated = bookAssembler.fromDto(bookDTO);

        if(bookRepository.existsById(id)) {
            updated.setId(id);
            bookRepository.save(updated);
        }

        return updated;
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
