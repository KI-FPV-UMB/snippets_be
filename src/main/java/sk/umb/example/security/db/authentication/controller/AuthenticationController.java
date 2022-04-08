package sk.umb.example.security.db.authentication.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import sk.umb.example.security.db.authentication.service.AuthenticationService;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/api/authentication")
    public void login(@RequestHeader("Authorization") String authentication) {
        System.out.println("Authenticated.");
    }

    @DeleteMapping("/api/authentication/{bearerToken}")
    public void logoff(String bearerToken) {
        System.out.println("Authenticated.");
    }
}
