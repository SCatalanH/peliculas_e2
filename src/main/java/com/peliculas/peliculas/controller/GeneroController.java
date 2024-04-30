package com.peliculas.peliculas.controller;

import com.peliculas.peliculas.model.Genero;
import com.peliculas.peliculas.service.GeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public ResponseEntity<List<Genero>> getAllGeneros() {
        List<Genero> generos = generoService.getAllGeneros();
        return new ResponseEntity<>(generos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable("id") Long id) {
        Genero genero = generoService.getGeneroById(id);
        if (genero != null) {
            return new ResponseEntity<>(genero, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Genero> createGenero(@RequestBody Genero genero) {
        Genero nuevoGenero = generoService.createGenero(genero);
        return new ResponseEntity<>(nuevoGenero, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable("id") Long id, @RequestBody Genero genero) {
        Genero generoActualizado = generoService.updateGenero(id, genero);
        if (generoActualizado != null) {
            return new ResponseEntity<>(generoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable("id") Long id) {
        generoService.deleteGenero(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
