package sk.uniza.fri.sem_vaii.aplication.assemblers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import sk.uniza.fri.sem_vaii.aplication.dtos.ReservationDTO;
import sk.uniza.fri.sem_vaii.domain.Reservation;

@Data
@RequiredArgsConstructor
public class ReservationAssembler {

    public static ReservationDTO toDto(Reservation reservation) {
        var reservationDto = new ReservationDTO();

        reservationDto.setId(reservation.getId());
        reservationDto.setNumber(reservation.getNumber());
        reservationDto.setEmail(reservation.getEmail());
        reservationDto.setReservationBooks(reservation.getReservationBooks());

        return reservationDto;
    }

    public static Reservation fromDto(ReservationDTO reservationDto) {
        var reservation = new Reservation();

        reservation.setId(reservationDto.getId());
        reservation.setNumber(reservationDto.getNumber());
        reservation.setEmail(reservationDto.getEmail());
        reservation.setReservationBooks(reservationDto.getReservationBooks());

        return reservation;
    }
}
