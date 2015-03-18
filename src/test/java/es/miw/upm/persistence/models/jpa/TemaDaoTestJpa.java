package es.miw.upm.persistence.models.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class TemaDaoTestJpa {
	public Tema tema1, tema2;
	public TemaDao daoTema;
	public List<Voto> votos;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
	}

	@Before
	public void before() {
		 votos= new ArrayList<Voto>();
		this.tema1 = new Tema("RollingStones",
				"¿Cómo puntuarías a esta banda en directo?");
		this.tema2 = new Tema("Java",
				"¿Cómo puntuarías tu nivel en este lenguaje de programación?");
		daoTema = DaoFactory.getFactory().getTemaDao();
		daoTema.create(tema1);
		daoTema.create(tema2);
	}

	@Test
	public void testRead() {
		assertEquals(tema1, daoTema.read(tema1.getIdTema()));
	}

	@Test
	public void testUpdateVoto() {
		tema1.setNombre("U2");

		daoTema.update(tema1);
		assertEquals(tema1, daoTema.read(tema1.getIdTema()));
	}

	@Test
	public void testDeleteByID() {
		daoTema.deleteById(tema2.getIdTema());
		assertNull(daoTema.read(tema2.getIdTema()));
	}

	@Test
	public void testFindAll() {
		assertEquals(2, daoTema.findAll().size());
	}


}
