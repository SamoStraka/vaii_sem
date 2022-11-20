package sk.uniza.fri.sem_vaii.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books", schema = "public")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Book {
    private @Id Long id;
    private String isbn;
    private String title;

    @Column(name = "release_year")
    private Long releaseYear;

    @Column(name = "number_of_pages")
    private Long numberOfPages;

    private String info;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorBooks")
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "book_genre",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> bookGenres = new HashSet<>();
}
