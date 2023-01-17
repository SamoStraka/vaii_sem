package sk.uniza.fri.sem_vaii.aplication.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import sk.uniza.fri.sem_vaii.domain.Book;

import java.util.Set;

@Data
@JsonInclude
public class ReservationDTO {
    private Long id;
    private Long number;
    private String email;
    private Set<Book> reservationBooks;
}
