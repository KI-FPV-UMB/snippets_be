package sk.umb.example.security.db.authentication.core;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public class BearerAuthenticationToken extends AbstractAuthenticationToken {

    public BearerAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public static Authentication getInstance(HttpServletRequest request) {
        return null;
    }
}
