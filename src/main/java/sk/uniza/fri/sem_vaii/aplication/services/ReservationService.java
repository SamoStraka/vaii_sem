package sk.uniza.fri.sem_vaii.aplication.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.uniza.fri.sem_vaii.aplication.assemblers.ReservationAssembler;
import sk.uniza.fri.sem_vaii.aplication.dtos.ReservationDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.ReservationRepository;
import sk.uniza.fri.sem_vaii.domain.Reservation;

import java.util.List;
@Service
@Data
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationAssembler reservationAssembler;
    private final ReservationRepository reservationRepository;

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation addReservation(ReservationDTO reservationDTO) {
        return reservationRepository.save(reservationAssembler.fromDto(reservationDTO));
    }

    public Reservation updateReservation(Long id, ReservationDTO reservationDTO) {
        var updated = reservationAssembler.fromDto(reservationDTO);

        if (reservationRepository.existsById(id)) {
            updated.setId(id);
            reservationRepository.save(updated);
        }

        return updated;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
