package com.peliculas.peliculas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.peliculas.peliculas.model.Pelicula;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculasRepositoryTests {
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Test
	public void guardarPeliculaTest() {
		Pelicula peliculas = new Pelicula();
		peliculas.setTitulo("Downfall");

		Pelicula resultado = peliculaRepository.save(peliculas);			assertEquals("Downfall", resultado);


		assertNotNull(resultado.getId());
	}
}
