package sk.umb.example.security.db.authentication.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sk.umb.example.security.db.authentication.dal.TokenEntity;
import sk.umb.example.security.db.authentication.dal.TokenRepository;
import sk.umb.example.security.db.authentication.dal.UserEntity;
import sk.umb.example.security.db.authentication.dal.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

// use https://bcrypt-generator.com/ with round = 1 to hash password

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, TokenRepository tokenRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticate(String username, String password) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Username and/or password do not match!");
        }

        if ( ! passwordEncoder.matches(password,
                                       optionalUser.get().getPasswordHash())) {
            throw new AuthenticationCredentialsNotFoundException("Username and/or password do not match!");
        }

        TokenEntity token = new TokenEntity();
        token.setToken(randomString());
        token.setUser(optionalUser.get());
        token.setValidUntil(LocalDateTime.now().plusMinutes(15));

        tokenRepository.save(token);

        return token.getToken();
    }

    public void authenticate(String token) {
    }

    private static String randomString() {
        return UUID.randomUUID().toString();
    }
}
