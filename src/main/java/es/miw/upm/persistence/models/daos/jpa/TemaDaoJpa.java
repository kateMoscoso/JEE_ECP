package es.miw.upm.persistence.models.daos.jpa;

import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.entities.Tema;



public class TemaDaoJpa extends GenericDaoJpa<Tema,Integer>implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

}
