package es.miw.upm.persistance.models.jdbc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jdbc.DaoJdbcFactory;
import es.miw.upm.persistence.models.entities.Voto;



public class VotoDaoJdbcTest {
    private VotoDao dao;

    private Voto voto;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJdbcFactory());
        DaoJdbcFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
        this.voto= new Voto("100.20.2.8",NivelEstudiosType.BASICO,10);
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
    }

    @Test
    public void testRead() {
        assertEquals(voto, dao.read(voto.getIdVoto()));
    }

    @Test
    public void testUpdateVoto() {
    	voto.setIp("100.20.2.8");

        dao.update(voto);
        assertEquals(voto, dao.read(voto.getIdVoto()));
    }

//    @Test
//    public void testDeleteByID() {
//        dao.deleteById(category.getId());
//        assertNull(dao.read(category.getId()));
//    }
//
//    @Test
//    public void testFindAll() {
//        dao.create(new Voto(2, "2", "2"));
//        dao.create(new Voto(3, "3", "3"));
//        assertEquals(3, dao.findAll().size());
//    }

    @After
    public void after() {
        DaoJdbcFactory.dropAndCreateTables();
    }

}
