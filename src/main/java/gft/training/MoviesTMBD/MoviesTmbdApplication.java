package gft.training.MoviesTMBD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@Configuration
public class MoviesTmbdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesTmbdApplication.class, args);
	}

}
