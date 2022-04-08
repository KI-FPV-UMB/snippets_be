package sk.umb.example.security.db.authentication.core;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class DemoAuthenticationFilter extends OncePerRequestFilter {
    private final DemoAuthenticationEntryPoint authenticationEntryPoint;

    private final AuthenticationManager authenticationManager;


    public DemoAuthenticationFilter(DemoAuthenticationEntryPoint authenticationEntryPoint,
                                    AuthenticationManager authenticationManager) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            Authentication authentication = BearerAuthenticationToken.getInstance(request);

            Authentication validatedAuthentication = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(validatedAuthentication);

            filterChain.doFilter(request, response);
        } catch (AuthenticationException aex) {
            SecurityContextHolder.clearContext();
            this.authenticationEntryPoint.commence(request, response, aex);
            return;
        }
    }
}
