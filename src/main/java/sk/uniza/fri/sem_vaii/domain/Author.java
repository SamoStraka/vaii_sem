package sk.uniza.fri.sem_vaii.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authors", schema = "public")
@Access(AccessType.FIELD)
@Getter @Setter @NoArgsConstructor
public class Author {
    private @Id Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
}
