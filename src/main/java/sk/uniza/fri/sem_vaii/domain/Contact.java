package sk.uniza.fri.sem_vaii.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "public")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Contact {
    private @Id
    Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private Boolean solved;
}
