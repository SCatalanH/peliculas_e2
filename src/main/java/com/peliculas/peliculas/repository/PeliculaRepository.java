package com.peliculas.peliculas.repository;

import com.peliculas.peliculas.model.Pelicula;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si es necesario

    Optional<Pelicula> findById(Long id);
}