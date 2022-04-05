package sk.umb.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityDBApplication {
	public static void main(String[] args) {
		System.out.println("Hello Spring Application!");

		SpringApplication.run(SecurityDBApplication.class, args);
	}
}
