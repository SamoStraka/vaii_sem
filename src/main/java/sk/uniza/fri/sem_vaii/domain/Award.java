package sk.uniza.fri.sem_vaii.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "awards", schema = "public")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class Award {
    @Id
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private Long priority;
}