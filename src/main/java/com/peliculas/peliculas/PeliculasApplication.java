package com.peliculas.peliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.peliculas.peliculas.controller", "com.peliculas.peliculas.service", "com.peliculas.peliculas.repository"})
public class PeliculasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeliculasApplication.class, args);
    }
}
