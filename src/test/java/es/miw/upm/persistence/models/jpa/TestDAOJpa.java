package es.miw.upm.persistence.models.jpa;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




import es.miw.upm.persistence.jpa.JpaFactory;
import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class TestDAOJpa {
	public Tema tema1, tema2;
	public Voto voto1, voto2;
	public TemaDao daoTema;
	public VotoDao daoVoto;
	public List<Voto> votos;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
		JpaFactory.dropAndCreateTables();
	}


	@Before
	public void before() {
		this.tema1 = new Tema("RollingStones", "¿Como puntuarias a los RollingStones?");
		this.voto1 = new Voto("100.20.2.8", NivelEstudiosType.BASICO,10);
		this.tema2 = new Tema("Muse", "¿Como puntuarias a Muse en directo?");
		this.voto2 = new Voto("100.20.3.8", NivelEstudiosType.BASICO,9);
		this.votos = new ArrayList<Voto>();
		votos.add(voto1);
		votos.add(new Voto("100.20.2.2",  NivelEstudiosType.BASICO,3));
		votos.add(new Voto("100.20.2.5",  NivelEstudiosType.INTERMEDIO,4));
		tema1.setVotos(votos);

		daoTema = DaoFactory.getFactory().getTemaDao();
		daoVoto = DaoFactory.getFactory().getVotoDao();
		daoTema.create(tema1);
		daoTema.create(tema2);
		daoVoto.create(voto1);
		daoVoto.create(voto2);
	}
	//	
	//	@Before
	//	public void init(){
	//		JpaFactory.dropAndCreateTables();
	//		em = JpaFactory.getEntityManagerFactory().createEntityManager();
	//		Tema tema1 = new Tema(1, "RollingStones", "¿Como puntuarias a los RollingStones?");
	//		Tema tema2 = new Tema(2, "Muse", "¿Como puntuarias a Muse en directo?");
	//		voto = new Voto("100.20.2.8", tema2, NivelEstudiosType.BASICO,10);
	//		List<Voto> votos = new ArrayList<Voto>();
	//		votos.add(voto);
	//		votos.add(new Voto("100.20.2.2", tema1, NivelEstudiosType.BASICO,3));
	//		votos.add(new Voto("100.20.2.5", tema1, NivelEstudiosType.INTERMEDIO,4));
	//		tema1.setVotos(votos);
	//		// Create
	//		em.getTransaction().begin();
	//		em.persist(tema1);
	//		em.persist(tema2);
	//		em.getTransaction().commit();
	//	}
//	@Test
//	public void testRead() {
//		assertEquals(tema, dao.read(tema.getId_tema()));
//	}

	//
	//	@Test
	//	public void testCreateVoto() { 
	//		assertEquals( "10", em.find(Voto.class, voto.getIdVoto()).getValorPuntuacion().toString());
	//
	//	}
	//	@Test
	//	public void testCreateTema() { 
	//		assertEquals( "RollingStones", em.find(Tema.class, 1).getIdTema());
	//	}
	//	@Test
	//	public void testNumeroVotos() { 
	//		assertEquals( 2, em.find(Tema.class, 1).getVotos().size());
	//	}
	//	@Test
	//	public void testAñadirVotos() { 
	//		assertEquals( 2, em.find(Tema.class, 1).getVotos().size());
	//	}
	//
	//	@Test
	//	public void testBorrarVoto(){
	//		em.getTransaction().begin();
	//		em.remove(em.find(Tema.class, 1));
	//		em.getTransaction().commit();
	//		assertNull(em.find(Tema.class, 1));
	//	}
	//	@After
	//	public void after() {
	//		JpaFactory.dropAndCreateTables();
	//		em.
	//	}


}
