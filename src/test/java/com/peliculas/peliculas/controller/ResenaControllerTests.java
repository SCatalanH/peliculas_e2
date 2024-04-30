package com.peliculas.peliculas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.peliculas.peliculas.model.Resena;
import com.peliculas.peliculas.service.ResenaService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResenaControllerTests {

    @Mock
    private ResenaService resenaService;

    @InjectMocks
    private ResenaController resenaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllResenas_ReturnsListOfResenas() {
        // Arrange
        Resena resena1 = new Resena();
        resena1.setId(1L);
        resena1.setComentario("Excelente película");

        Resena resena2 = new Resena();
        resena2.setId(2L);
        resena2.setComentario("Muy entretenida");

        List<Resena> resenas = new ArrayList<>();
        resenas.add(resena1);
        resenas.add(resena2);

        when(resenaService.getAllResenas()).thenReturn(resenas);

        // Act
        ResponseEntity<List<Resena>> responseEntity = resenaController.getAllResenas();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(resenas, responseEntity.getBody());
    }
}
