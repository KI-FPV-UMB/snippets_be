package sk.umb.example.security.db.authentication.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Service;
import sk.umb.example.security.db.authentication.dal.UserEntity;
import sk.umb.example.security.db.authentication.dal.UserRepository;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String authenticate(String username, String password) {
        String passwordHash = getPasswordHash(password);
        Optional<UserEntity> optionalUser = userRepository.findByUsernameAndPasswordHash(username, passwordHash);

        if (optionalUser.isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("User Not Found!");
        }

        return Strings.EMPTY;
    }

    public void authenticate(String token) {
    }

    private String getPasswordHash(String password) {
        return "123456";
    }
}
