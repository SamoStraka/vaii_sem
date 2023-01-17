package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.JwtUtils;
import sk.uniza.fri.sem_vaii.aplication.dtos.UserDTO;
import sk.uniza.fri.sem_vaii.aplication.repositories.UserRepository;

import java.util.Collections;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    /**
     * inspirovane: https://www.youtube.com/watch?v=b9O9NI-RJ3o
     * **/

    @PostMapping("/api/login")
    public ResponseEntity<String> login (@RequestBody UserDTO userDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword())
        );
        var user1 = userRepository.findByUsername(userDTO.getUsername()).stream().findFirst().orElseThrow(() -> new UsernameNotFoundException("no username"));
        final UserDetails user = new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));

        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return  ResponseEntity.status(400).body("Error");
    }
}
