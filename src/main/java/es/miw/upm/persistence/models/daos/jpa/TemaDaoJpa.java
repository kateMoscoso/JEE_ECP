package es.miw.upm.persistence.models.daos.jpa;

import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.entities.TemaEntity;



public class TemaDaoJpa extends GenericDaoJpa<TemaEntity,Integer>implements TemaDao {

	public TemaDaoJpa() {
		super(TemaEntity.class);
		// TODO Auto-generated constructor stub
	}

}
