package sk.umb.example.security.db.authentication.core;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import sk.umb.example.security.db.authentication.service.AuthenticationService;

public class BearerAuthenticationProvider implements AuthenticationProvider {
    private final AuthenticationService authenticationService;

    public BearerAuthenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
