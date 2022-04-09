package sk.umb.example.security.db.authentication.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sk.umb.example.security.db.authentication.service.AuthenticationService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DemoAuthenticationEntryPoint demoAuthenticationEntryPoint;
    private final AuthenticationService authenticationService;

    public WebSecurityConfig(DemoAuthenticationEntryPoint demoAuthenticationEntryPoint,
                             AuthenticationService authenticationService) {
        this.demoAuthenticationEntryPoint = demoAuthenticationEntryPoint;
        this.authenticationService = authenticationService;
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.POST, "/api/authentication");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(demoAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(new DemoAuthenticationFilter(authenticationService), UsernamePasswordAuthenticationFilter.class);
    }
}
