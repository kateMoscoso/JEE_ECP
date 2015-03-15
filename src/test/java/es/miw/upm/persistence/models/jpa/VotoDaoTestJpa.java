package es.miw.upm.persistence.models.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Voto;

public class VotoDaoTestJpa {
	public Voto voto1, voto2, voto3;
	public VotoDao daoVoto;

	@BeforeClass
	public static void beforeClass() {
		DaoFactory.setFactory(new DaoJpaFactory());
	}

	@Before
	public void before() {
		this.voto1 = new Voto("100.20.2.8", NivelEstudiosType.BASICO,10);
		this.voto2 = new Voto("100.20.3.8", NivelEstudiosType.BASICO,9);
		daoVoto = DaoFactory.getFactory().getVotoDao();
		daoVoto.create(voto1);
		daoVoto.create(voto2);

	}

	@Test
	public void testRead() {
		assertEquals(voto1, daoVoto.read(voto1.getIdVoto()));
	}

	@Test
	public void testUpdateVoto() {
		voto2.setValor(5);
		daoVoto.update(voto2);
		assertEquals("5", daoVoto.read(voto2.getIdVoto()).getValor().toString());
	}

	@Test
	public void testDeleteByID() {
		daoVoto.deleteById(voto1.getIdVoto());
		assertNull(daoVoto.read(voto1.getIdVoto()));
	}

	@Test
	public void testFindAll() {
		assertEquals(2, daoVoto.findAll().size());
	}
}
