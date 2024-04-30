package com.peliculas.peliculas.service;

import com.peliculas.peliculas.model.Director;
import com.peliculas.peliculas.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectores() {
        return directorRepository.findAll();
    }

    public Director getDirectorById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director updateDirector(Long id, Director director) {
        if (directorRepository.existsById(id)) {
            director.setId(id);
            return directorRepository.save(director);
        }
        return null; // O manejo de excepciones
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
