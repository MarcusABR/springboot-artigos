package br.com.bb.letscode.artigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArtigosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtigosApplication.class, args);
	}

}
