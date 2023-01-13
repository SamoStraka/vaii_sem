package sk.uniza.fri.sem_vaii.aplication.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import sk.uniza.fri.sem_vaii.domain.Author;
import sk.uniza.fri.sem_vaii.domain.Genre;
import sk.uniza.fri.sem_vaii.domain.Language;

import java.util.HashSet;
import java.util.Set;

@Data
@JsonInclude
public class BookDTO {
    private Long id;
    private String isbn;
    private String title;
    private Long releaseYear;
    private Long numberOfPages;
    private String info;
    private Set<Author> authors = new HashSet<>();
    private Set<Genre> bookGenres = new HashSet<>();
    private Language language = new Language();
}
