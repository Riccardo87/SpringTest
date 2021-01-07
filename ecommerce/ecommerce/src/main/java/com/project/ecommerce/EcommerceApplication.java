package com.project.ecommerce;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


	@Bean
	ApplicationRunner init(User repository) {
		// Save our starter set of books
		return args -> {
			Stream.of(new User(1, "1", "dd", "12/12/12"),
					new User(2, "qwe", "dff", "12/12/12"),
					new User(3, "vvv", "vvv", "77/77///")).forEach(user -> {
				repository.save(user);
			});

			repository.findAll().forEach(System.out::println);
		};
	}
}
