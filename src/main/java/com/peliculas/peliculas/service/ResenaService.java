package com.peliculas.peliculas.service;

import com.peliculas.peliculas.model.Resena;

import java.util.List;

public interface ResenaService {
    List<Resena> getAllResenas();

    Resena getResenaById(Long id);

    Resena createResena(Resena resena);

    Resena updateResena(Long id, Resena resena);

    void deleteResena(Long id);
}
