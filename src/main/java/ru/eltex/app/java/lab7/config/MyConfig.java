package ru.eltex.app.java.lab7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.eltex.app.java.lab1.Coffee;

@Configuration
public class MyConfig {
    @Bean
    public Coffee getCofee() {
        return new Coffee();
    }
}
