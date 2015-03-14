package es.miw.upm.persistence.models.daos.jpa;


import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto,Integer>implements VotoDao  {

	public VotoDaoJpa() {
		super(Voto.class);
	}

}
