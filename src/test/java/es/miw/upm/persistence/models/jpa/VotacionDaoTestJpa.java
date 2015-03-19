package es.miw.upm.persistence.models.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

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

public class VotacionDaoTestJpa {
	public Voto voto1, voto2, voto3;
	public VotoDao daoVoto;
	public Tema tema1, tema2;
	public TemaDao daoTema;
	public List<Voto> votos;


	@Before
	public void before() {
		DaoFactory.setFactory(new DaoJpaFactory());
		JpaFactory.dropAndCreateTables();
		daoVoto = DaoFactory.getFactory().getVotoDao();
		daoTema = DaoFactory.getFactory().getTemaDao();
		voto1 = new Voto("100.20.2.8", NivelEstudiosType.BASICO,10);
		voto2 = new Voto("100.20.3.8", NivelEstudiosType.BASICO,9);
		daoVoto.create(voto1);
		daoVoto.create(voto2);
		tema1 = new Tema("RollingStones",
				"¿Cómo puntuarías a esta banda en directo?");
		tema2 = new Tema("Java",
				"¿Cómo puntuarías tu nivel en este lenguaje de programación?");
		System.out.println(voto1.toString());
		System.out.println(voto2.toString());
		System.out.println("Tema1: "+tema1.toString());
		tema1.getVotos().add(voto1);
		daoTema.create(tema1);
//		tema1 = daoTema.read(tema1.getIdTema()).getVotos().add(voto1);
		daoTema.update(tema1);
		//		tema1.setVotos(votos);

		daoTema.create(tema2);
		System.out.println(tema1.toString());
		System.out.println(tema2.toString());
	}
	
		@Test
		public void testReadVoto() {
			assertEquals(voto1, daoVoto.read(voto1.getIdVoto()));
		}
		@Test
		public void testReadTema() {
			assertEquals(tema2, daoTema.read(tema2.getIdTema()));
		}
	
		@Test
		public void testUpdateVoto() {
			voto2.setValor(5);
			daoVoto.update(voto2);
			assertEquals("5", daoVoto.read(voto2.getIdVoto()).getValor().toString());
		}
	@Test
	public void testUpdateTema() {
		voto3 = new Voto("100.20.3.2", NivelEstudiosType.BASICO,9);
		daoVoto.create(voto3);
		tema1 = daoTema.read(tema1.getIdTema());
		System.err.println("TEMA: "+ tema1.toString());
		tema1.getVotos().add(voto3);
		daoTema.update(tema1);
		System.out.println("tamaño de la lista"+daoTema.read(tema1.getIdTema()).getVotos().size());
		assertEquals(2, daoTema.read(tema1.getIdTema()).getVotos().size());
	}


}
