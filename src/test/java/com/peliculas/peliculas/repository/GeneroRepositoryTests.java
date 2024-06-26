package com.peliculas.peliculas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.peliculas.peliculas.model.Genero;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GeneroRepositoryTests {
	@Autowired
	private GeneroRepository generoRepository;

	@Test
	public void guardarPeliculaTest() {
		Genero genero = new Genero();
		genero.setNombre("Accion");

		Genero resultado = generoRepository.save(genero);


    	assertEquals("Accion", resultado);


		assertNotNull(resultado.getId());
	}
}
