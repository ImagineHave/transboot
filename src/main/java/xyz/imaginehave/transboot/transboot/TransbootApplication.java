package xyz.imaginehave.transboot.transboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaAuditing
@EnableWebSecurity
public class TransbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransbootApplication.class, args);
	}
}
