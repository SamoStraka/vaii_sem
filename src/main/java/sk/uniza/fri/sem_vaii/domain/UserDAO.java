package sk.uniza.fri.sem_vaii.domain;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAO {

    private final static List<UserDetails> USERS = Arrays.asList(
            new User("myname", "pass", Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("admin", "admin", Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")))
    );

    public UserDetails findUserBytName(String name) {
        return USERS
                .stream()
                .filter(u -> u.getUsername().equals(name))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No username"));
    }
}
