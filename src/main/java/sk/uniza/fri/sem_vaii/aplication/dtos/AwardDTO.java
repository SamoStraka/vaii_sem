package sk.uniza.fri.sem_vaii.aplication.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class AwardDTO {
    private Long id;
    private String name;
    private Long priority;
}
