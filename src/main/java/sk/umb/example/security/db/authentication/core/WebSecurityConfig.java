package sk.umb.example.security.db.authentication.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DemoAuthenticationFilter demoAuthenticationFilter;
    private final DemoAuthenticationEntryPoint demoAuthenticationEntryPoint;

    public WebSecurityConfig(DemoAuthenticationFilter demoAuthenticationFilter,
                             DemoAuthenticationEntryPoint demoAuthenticationEntryPoint) {
        this.demoAuthenticationFilter = demoAuthenticationFilter;
        this.demoAuthenticationEntryPoint = demoAuthenticationEntryPoint;
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.POST, "/api/authentication");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(demoAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilterBefore(demoAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public FilterRegistrationBean registration(DemoAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

}
