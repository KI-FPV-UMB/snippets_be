package sk.umb.example.security.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class SecurityDBApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurityDBApplication.class, args);
	}
}
