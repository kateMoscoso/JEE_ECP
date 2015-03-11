package es.miw.upm.persistence.models.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import es.miw.upm.persistence.jpa.JpaFactory;
import es.miw.upm.persistence.jpa.Tema;
import es.miw.upm.persistence.jpa.Voto;
import es.miw.upm.persistence.model.utils.NivelEstudiosType;

public class TestDAOJpa {
	private EntityManager em;

	@Before
	public void init(){
		JpaFactory.dropAndCreateTables();
		em = JpaFactory.getEntityManagerFactory().createEntityManager();
		Tema tema1 = new Tema(1, "RollingStones", "¿Como puntuarias a los RollingStones?",5);
		Tema tema2 = new Tema(2, "Muse", "¿Como puntuarias a Muse en directo?",6);

		List<Voto> votos = new ArrayList<Voto>();
		votos.add(new Voto("100.20.2.2", tema1, NivelEstudiosType.BASICO,3));
		votos.add(new Voto("100.20.2.5", tema1, NivelEstudiosType.INTERMEDIO,4));
		tema1.setVotos(votos);
		// Create
		em.getTransaction().begin();
		em.persist(tema1);
		em.persist(tema2);
		em.getTransaction().commit();
	}
	
	@Test
	public void testVoto() { 
		Tema tema = em.find(Tema.class, 1);
		assertEquals( "1", tema.getIdTema().toString());
	}
	
	@Test
	public void testBorrarVoto(){
		
		
	}
}
