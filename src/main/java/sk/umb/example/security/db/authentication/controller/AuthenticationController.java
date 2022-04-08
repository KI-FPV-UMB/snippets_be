package sk.umb.example.security.db.authentication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import sk.umb.example.security.db.authentication.service.AuthenticationService;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/api/authentication")
    public void login(@RequestHeader(value = "Authorization", required = false) Optional<String> authentication,
                      HttpServletResponse response) {
        if (authentication.isEmpty()) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }

        String[] credentials = credentialsDecode(authentication.get());

        String token = authenticationService.authenticate(credentials[0], credentials[1]);

        response.setStatus(HttpStatus.OK.value());
        response.addHeader("Authorization", "Bearer " + token);
    }

    private static String[] credentialsDecode(String authorization) {
        String base64Credentials = authorization.substring("Basic".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        return  credentials.split(":", 2);
    }

    @DeleteMapping("/api/authentication")
    public void logoff(String bearerToken) {
        System.out.println("Authenticated.");
    }
}
