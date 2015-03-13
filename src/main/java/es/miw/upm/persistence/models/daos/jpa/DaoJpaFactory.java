package es.miw.upm.persistence.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;

public class DaoJpaFactory extends DaoFactory{
	 private static final String PERSISTENCE_UNIT = "Votacion";

	    private static EntityManagerFactory entityManagerFactory = Persistence
	            .createEntityManagerFactory(PERSISTENCE_UNIT);

	    public DaoJpaFactory() {
	       // LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
	    }

	    public static EntityManagerFactory getEntityManagerFactory() {
	        return entityManagerFactory;
	    }
	@Override
	public TemaDao getTemaDao() {
		// TODO Auto-generated method stub
		return new TemaDaoJpa();
	}

	@Override
	public VotoDao getVotoDao() {
		// TODO Auto-generated method stub
		return new VotoDaoJpa();
	}

}
