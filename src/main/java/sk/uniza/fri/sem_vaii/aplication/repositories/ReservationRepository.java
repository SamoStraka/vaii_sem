package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.fri.sem_vaii.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
