package com.peliculas.peliculas.controller;

import com.peliculas.peliculas.model.Resena;
import com.peliculas.peliculas.service.ResenaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping
    public ResponseEntity<List<Resena>> getAllResenas() {
        List<Resena> resenas = resenaService.getAllResenas();
        return new ResponseEntity<>(resenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> getResenaById(@PathVariable("id") Long id) {
        Resena resena = resenaService.getResenaById(id);
        if (resena != null) {
            return new ResponseEntity<>(resena, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Resena> createResena(@RequestBody Resena resena) {
        Resena nuevaResena = resenaService.createResena(resena);
        return new ResponseEntity<>(nuevaResena, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> updateResena(@PathVariable("id") Long id, @RequestBody Resena resena) {
        Resena resenaActualizada = resenaService.updateResena(id, resena);
        if (resenaActualizada != null) {
            return new ResponseEntity<>(resenaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResena(@PathVariable("id") Long id) {
        resenaService.deleteResena(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
