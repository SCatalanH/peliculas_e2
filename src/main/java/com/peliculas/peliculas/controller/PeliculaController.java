package com.peliculas.peliculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("/")
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula peliculaActualizada) {
        Pelicula pelicula = peliculaRepository.findById(id).orElse(null);
        if (pelicula != null) {
            pelicula.setTitulo(peliculaActualizada.getTitulo());
            pelicula.setDirector(peliculaActualizada.getDirector());
            // Actualizar otros atributos
            return peliculaRepository.save(pelicula);
        }
        return null; // Manejar el caso cuando no se encuentra la película
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliculaRepository.deleteById(id);
    }
}