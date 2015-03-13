package es.miw.upm.persistence.models.daos.jpa;

import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.entities.TemaEntity;
import es.miw.upm.persistence.models.entities.VotoEntity;

public class VotoDaoJpa extends GenericDaoJpa<VotoEntity,Integer>implements VotoDao  {

	public VotoDaoJpa() {
		super(VotoEntity.class);
		// TODO Auto-generated constructor stub
	}

}
