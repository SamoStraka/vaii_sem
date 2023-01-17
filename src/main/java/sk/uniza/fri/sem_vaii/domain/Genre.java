package sk.uniza.fri.sem_vaii.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Name is mandatory")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "bookGenres")
    private Set<Book> books = new HashSet<>();
}
