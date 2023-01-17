package sk.uniza.fri.sem_vaii.aplication.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import sk.uniza.fri.sem_vaii.aplication.JwtUtils;
import sk.uniza.fri.sem_vaii.aplication.dtos.UserDTO;
import sk.uniza.fri.sem_vaii.domain.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class AuthController {

    private final SecurityContextLogoutHandler logoutHandler;
    private final HttpSessionSecurityContextRepository securityContextRepository;
    private final AuthenticationManager authenticationManager;
    private final UserDAO userDAO;
    private final JwtUtils jwtUtils;

    private final SessionRegistry sessionRegistry;

    @PostMapping("/api/login")
    public ResponseEntity<String> login (@RequestBody UserDTO userDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        List<SessionInformation> sessions = sessionRegistry.getAllSessions(authentication.getPrincipal(), false);
        final UserDetails user1 = userDAO.findUserBytName(userDTO.getUsername());
        var nn = new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword());
        authenticationManager.authenticate(
                nn
        );
        final UserDetails user = userDAO.findUserBytName(userDTO.getUsername());
        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return  ResponseEntity.status(400).body("Error");
    }

    @PostMapping("/logoutuj")
    @ResponseBody
    public String currentUser(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        logoutHandler.logout(request, response, authentication);
        List<SessionInformation> sessions = sessionRegistry.getAllSessions(authentication.getPrincipal(), false);
        for (SessionInformation session : sessions) {
            session.expireNow();
        }
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
        return "logged out";
    }
}
