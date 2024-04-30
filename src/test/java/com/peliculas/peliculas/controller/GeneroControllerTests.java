package com.peliculas.peliculas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.peliculas.peliculas.model.Genero;
import com.peliculas.peliculas.service.GeneroService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GeneroControllerTests {

    @Mock
    private GeneroService generoService;

    @InjectMocks
    private GeneroController generoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllGeneros_ReturnsListOfGeneros() {
        // Arrange
        Genero genero1 = new Genero();
        genero1.setId(1L);
        genero1.setNombre("Acción");

        Genero genero2 = new Genero();
        genero2.setId(2L);
        genero2.setNombre("Comedia");

        List<Genero> generos = new ArrayList<>();
        generos.add(genero1);
        generos.add(genero2);

        when(generoService.getAllGeneros()).thenReturn(generos);

        // Act
        ResponseEntity<List<Genero>> responseEntity = generoController.getAllGeneros();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(generos, responseEntity.getBody());
    }
}
