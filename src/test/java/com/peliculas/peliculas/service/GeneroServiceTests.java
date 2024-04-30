package com.peliculas.peliculas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.peliculas.peliculas.model.Genero;
import com.peliculas.peliculas.repository.GeneroRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GeneroServiceTests {

    @Mock
    private GeneroRepository generoRepository;

    @InjectMocks
    private GeneroService generoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllGeneros_ReturnsListOfGeneros() {
        // Arrange
        Genero genero1 = new Genero();
        genero1.setId(1L);
        genero1.setNombre("Drama");

        Genero genero2 = new Genero();
        genero2.setId(2L);
        genero2.setNombre("Comedia");

        List<Genero> generos = new ArrayList<>();
        generos.add(genero1);
        generos.add(genero2);

        when(generoRepository.findAll()).thenReturn(generos);

        // Act
        List<Genero> result = generoService.getAllGeneros();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(generos, result);
    }

    @Test
    public void getGeneroById_ReturnsGenero_WhenFound() {
        // Arrange
        Long generoId = 1L;
        Genero genero = new Genero();
        genero.setId(generoId);
        genero.setNombre("Drama");

        when(generoRepository.findById(generoId)).thenReturn(Optional.of(genero));

        // Act
        Genero result = generoService.getGeneroById(generoId);

        // Assert
        assertNotNull(result);
        assertEquals(genero, result);
    }

    @Test
    public void getGeneroById_ReturnsNull_WhenNotFound() {
        // Arrange
        Long generoId = 1L;

        when(generoRepository.findById(generoId)).thenReturn(Optional.empty());

        // Act
        Genero result = generoService.getGeneroById(generoId);

        // Assert
        assertNull(result);
    }

    @Test
    public void createGenero_ReturnsCreatedGenero() {
        // Arrange
        Genero genero = new Genero();
        genero.setNombre("Drama");

        when(generoRepository.save(genero)).thenReturn(genero);

        // Act
        Genero result = generoService.createGenero(genero);

        // Assert
        assertNotNull(result);
        assertEquals(genero, result);
    }

    // Tests for updateGenero and deleteGenero methods can be similarly implemented
}
