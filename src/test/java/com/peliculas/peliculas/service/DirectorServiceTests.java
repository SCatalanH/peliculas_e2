package com.peliculas.peliculas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.peliculas.peliculas.model.Director;
import com.peliculas.peliculas.repository.DirectorRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DirectorServiceTests {

    @Mock
    private DirectorRepository directorRepository;

    @InjectMocks
    private DirectorService directorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllDirectores_ReturnsListOfDirectores() {
        // Arrange
        Director director1 = new Director();
        director1.setId(1L);
        director1.setNombre("Steven Spielberg");

        Director director2 = new Director();
        director2.setId(2L);
        director2.setNombre("Christopher Nolan");

        List<Director> directores = new ArrayList<>();
        directores.add(director1);
        directores.add(director2);

        when(directorRepository.findAll()).thenReturn(directores);

        // Act
        List<Director> result = directorService.getAllDirectores();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(directores, result);
    }

    @Test
    public void getDirectorById_ReturnsDirector_WhenFound() {
        // Arrange
        Long directorId = 1L;
        Director director = new Director();
        director.setId(directorId);
        director.setNombre("Steven Spielberg");

        when(directorRepository.findById(directorId)).thenReturn(Optional.of(director));

        // Act
        Director result = directorService.getDirectorById(directorId);

        // Assert
        assertNotNull(result);
        assertEquals(director, result);
    }

    @Test
    public void getDirectorById_ReturnsNull_WhenNotFound() {
        // Arrange
        Long directorId = 1L;

        when(directorRepository.findById(directorId)).thenReturn(Optional.empty());

        // Act
        Director result = directorService.getDirectorById(directorId);

        // Assert
        assertNull(result);
    }

    @Test
    public void createDirector_ReturnsCreatedDirector() {
        // Arrange
        Director director = new Director();
        director.setNombre("Christopher Nolan");

        when(directorRepository.save(director)).thenReturn(director);

        // Act
        Director result = directorService.createDirector(director);

        // Assert
        assertNotNull(result);
        assertEquals(director, result);
    }

    // Tests for updateDirector and deleteDirector methods can be similarly implemented
}
