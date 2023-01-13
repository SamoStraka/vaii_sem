package sk.uniza.fri.sem_vaii.aplication.assemblers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sk.uniza.fri.sem_vaii.aplication.dtos.BookDTO;
import sk.uniza.fri.sem_vaii.domain.Book;

@Data
@RequiredArgsConstructor
public class BookAssembler {
    public static BookDTO toDto(Book book) {
        var bookDto = new BookDTO();

        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setTitle(book.getTitle());
        bookDto.setReleaseYear(book.getReleaseYear());
        bookDto.setNumberOfPages(book.getNumberOfPages());
        bookDto.setInfo(book.getInfo());
        bookDto.setAuthors(book.getAuthors());
        bookDto.setBookGenres(book.getBookGenres());
        bookDto.setLanguage(book.getLanguage());

        return bookDto;
    }

    public Book fromDto(BookDTO bookDTO) {
        var book = new Book();

        book.setId(bookDTO.getId());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setReleaseYear(bookDTO.getReleaseYear());
        book.setNumberOfPages(bookDTO.getNumberOfPages());
        book.setInfo(bookDTO.getInfo());
        book.setAuthors(bookDTO.getAuthors());
        book.setBookGenres(bookDTO.getBookGenres());
        book.setLanguage(bookDTO.getLanguage());

        return book;
    }
}
