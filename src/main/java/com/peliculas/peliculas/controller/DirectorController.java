package com.peliculas.peliculas.controller;

import com.peliculas.peliculas.model.Director;
import com.peliculas.peliculas.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/directores")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectores() {
        List<Director> directores = directorService.getAllDirectores();
        return new ResponseEntity<>(directores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable("id") Long id) {
        Director director = directorService.getDirectorById(id);
        if (director != null) {
            return new ResponseEntity<>(director, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        Director nuevoDirector = directorService.createDirector(director);
        return new ResponseEntity<>(nuevoDirector, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable("id") Long id, @RequestBody Director director) {
        Director directorActualizado = directorService.updateDirector(id, director);
        if (directorActualizado != null) {
            return new ResponseEntity<>(directorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirector(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
