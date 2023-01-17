package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.assemblers.ReservationAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.ReservationDTO;
import sk.uniza.fri.sem_vaii.aplication.services.ReservationService;
import sk.uniza.fri.sem_vaii.domain.Reservation;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("{id}")
    ReservationDTO getReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservation(id);
        return ReservationAssembler.toDto(reservation);
    }

    @GetMapping()
    Iterable<ReservationDTO> getReservations() {
        return reservationService.getReservations().stream()
                .map(ReservationAssembler::toDto).toList();
    }

    @PostMapping()
    ReservationDTO newReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        if (reservationService.getReservation(reservationDTO.getId()) != null) {
            throw new RuntimeException();
        }

        return ReservationAssembler.toDto(reservationService.addReservation(reservationDTO));
    }

    @DeleteMapping("{id}")
    void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
