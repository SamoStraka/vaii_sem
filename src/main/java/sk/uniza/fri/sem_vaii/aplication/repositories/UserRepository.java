package sk.uniza.fri.sem_vaii.aplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.fri.sem_vaii.domain.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByUsername(String username);

}
