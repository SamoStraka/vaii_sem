package sk.uniza.fri.sem_vaii.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors", schema = "public")
@Access(AccessType.FIELD)
@Getter @Setter @NoArgsConstructor
public class Author {
    private @Id
    Long id;

    @NotBlank(message = "Last name is mandatory")
    @Size(min=1, max=30)
    private String name;

    @NotBlank(message = "Last name is mandatory")
    @Size(min=1, max=30)
    @Column(name = "last_name")
    private String lastName;
    private String info;

    @ManyToMany
    @JoinTable(
            name = "authors_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> authorBooks = new HashSet<>();
}
