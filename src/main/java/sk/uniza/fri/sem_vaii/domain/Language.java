package sk.uniza.fri.sem_vaii.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "languages", schema = "public")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Language {
    private @Id
    Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "language")
    private Set<Book> books;
}
