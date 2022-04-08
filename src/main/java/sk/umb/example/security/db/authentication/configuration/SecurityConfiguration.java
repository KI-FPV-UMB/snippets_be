package sk.umb.example.security.db.authentication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sk.umb.example.security.db.authentication.core.DemoAuthenticationEntryPoint;
import sk.umb.example.security.db.authentication.core.DemoAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final DemoAuthenticationEntryPoint demoAuthenticationEntryPoint;
    private final DemoAuthenticationFilter demoAuthenticationFilter;

    public SecurityConfiguration(DemoAuthenticationEntryPoint demoAuthenticationEntryPoint,
                                 DemoAuthenticationFilter demoAuthenticationFilter) {
        this.demoAuthenticationEntryPoint = demoAuthenticationEntryPoint;
        this.demoAuthenticationFilter = demoAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.POST, "/api/authentication");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(demoAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(demoAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
