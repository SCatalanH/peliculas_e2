package com.peliculas.peliculas.service;

import com.peliculas.peliculas.model.Resena;
import com.peliculas.peliculas.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaServiceImpl implements ResenaService {

    private final ResenaRepository resenaRepository;

    @Autowired
    public ResenaServiceImpl(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    @Override
    public List<Resena> getAllResenas() {
        return resenaRepository.findAll();
    }

    @Override
    public Resena getResenaById(Long id) {
        return resenaRepository.findById(id).orElse(null);
    }

    @Override
    public Resena createResena(Resena resena) {
        return resenaRepository.save(resena);
    }

    @Override
    public Resena updateResena(Long id, Resena resena) {
        if (resenaRepository.existsById(id)) {
            resena.setId(id);
            return resenaRepository.save(resena);
        }
        return null;
    }

    @Override
    public void deleteResena(Long id) {
        resenaRepository.deleteById(id);
    }
}
