package sk.uniza.fri.sem_vaii.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private @Id
    Long id;
    private String username;
    private String password;
}
