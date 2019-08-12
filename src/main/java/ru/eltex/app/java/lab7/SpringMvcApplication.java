package ru.eltex.app.java.lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EntityScan("ru.eltex.app.java")
public class SpringMvcApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringMvcApplication.class, args);
    }
}
