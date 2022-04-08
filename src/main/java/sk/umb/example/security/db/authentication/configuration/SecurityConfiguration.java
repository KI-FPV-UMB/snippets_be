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

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.POST, "/api/authentication");
    }

//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable()
//                .authorizeRequests().antMatchers("/login")..and()
//                .exceptionHandling().authenticationEntryPoint(aceAuthenticationEntryPoint).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .addFilterBefore(aceAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//    }

}
