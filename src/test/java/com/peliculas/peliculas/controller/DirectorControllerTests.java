package com.peliculas.peliculas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.peliculas.peliculas.model.Director;
import com.peliculas.peliculas.service.DirectorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DirectorControllerTests {

    @Mock
    private DirectorService directorService;

    @InjectMocks
    private DirectorController directorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllDirectores_ReturnsListOfDirectores() {
        // Arrange
        Director director1 = new Director();
        director1.setId(1L);
        director1.setNombre("Christopher Nolan");

        Director director2 = new Director();
        director2.setId(2L);
        director2.setNombre("Quentin Tarantino");

        List<Director> directores = new ArrayList<>();
        directores.add(director1);
        directores.add(director2);

        when(directorService.getAllDirectores()).thenReturn(directores);

        // Act
        ResponseEntity<List<Director>> responseEntity = directorController.getAllDirectores();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(directores, responseEntity.getBody());
    }
}
