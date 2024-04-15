package com.peliculas.peliculas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.peliculas.peliculas.repository.PeliculaRepository;
import com.peliculas.peliculas.model.Pelicula;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public Pelicula createPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula updatePelicula(Long id, Pelicula pelicula) {
        Optional<Pelicula> optionalPelicula = peliculaRepository.findById(id);
        if (optionalPelicula.isPresent()) {
            pelicula.setId(id);
            return peliculaRepository.save(pelicula);
        }
        return null;
    }

    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }

    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula getPeliculaById(Long id) {
        Optional<Pelicula> optionalPelicula = peliculaRepository.findById(id);
        return optionalPelicula.orElse(null);
    }
}