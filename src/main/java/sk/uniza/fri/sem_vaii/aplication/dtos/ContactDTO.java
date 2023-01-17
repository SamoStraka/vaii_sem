package sk.uniza.fri.sem_vaii.aplication.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class ContactDTO {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private Boolean solved;
}
