package sk.uniza.fri.sem_vaii.aplication.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import sk.uniza.fri.sem_vaii.domain.Book;

import java.util.Set;

@Data
@JsonInclude
public class AuthorDTO {
    private Long id;
    private String name;
    private String lastName;
    private String info;
    private Set<Book> authorBooks;
}
