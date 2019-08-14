package ru.eltex.app.java.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ru.eltex.app.java")
@ComponentScan("ru.eltex.app.java")
@EnableJpaRepositories("ru.eltex.app.java.lab8.repositories")
public class SpringMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }
}
