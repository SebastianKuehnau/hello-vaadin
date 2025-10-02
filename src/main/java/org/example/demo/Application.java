package org.example.demo;

import org.example.demo.data.Person;
import org.example.demo.data.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        return args -> {
            repository.saveAll(List.of(new Person("John", 25, "john@localhost.wow"),
                    new Person("Jane", 23, "jane@yahoo.com"),
                    new Person("Jack", 22, "jack@gmail.com")));
        };
    };

}
