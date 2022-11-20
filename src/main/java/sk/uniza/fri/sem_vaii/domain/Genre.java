package sk.uniza.fri.sem_vaii.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres", schema = "public")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Genre {
    private @Id
    Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookGenres")
    private Set<Book> books = new HashSet<>();
}
