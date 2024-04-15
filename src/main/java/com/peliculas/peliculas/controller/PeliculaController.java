package com.peliculas.peliculas.controller;

import com.peliculas.peliculas.model.Pelicula;
import com.peliculas.peliculas.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Endpoint para obtener todas las películas
    @GetMapping
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.getAllPeliculas();
        return new ResponseEntity<>(peliculas, HttpStatus.OK);
    }

    // Endpoint para obtener una película por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") Long id) {
        Pelicula pelicula = peliculaService.getPeliculaById(id);
        if (pelicula != null) {
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para agregar una nueva película
    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.createPelicula(pelicula);
        return new ResponseEntity<>(nuevaPelicula, HttpStatus.CREATED);
    }

    // Endpoint para actualizar una película existente
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        Pelicula peliculaActualizada = peliculaService.updatePelicula(id, pelicula);
        if (peliculaActualizada != null) {
            return new ResponseEntity<>(peliculaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una película
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable("id") Long id) {
        peliculaService.deletePelicula(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
