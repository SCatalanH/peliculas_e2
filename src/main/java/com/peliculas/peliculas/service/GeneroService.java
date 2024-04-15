package com.peliculas.peliculas.service;

import com.peliculas.peliculas.model.Genero;
import com.peliculas.peliculas.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    @Autowired
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }

    public Genero getGeneroById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero createGenero(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero updateGenero(Long id, Genero genero) {
        if (generoRepository.existsById(id)) {
            genero.setId(id);
            return generoRepository.save(genero);
        }
        return null; // O manejo de excepciones
    }

    public void deleteGenero(Long id) {
        generoRepository.deleteById(id);
    }
}
