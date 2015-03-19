package es.miw.upm.web.controllers;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;

public class IncorporarTemaController {
	private TemaDao temaDao;

	public IncorporarTemaController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}

	public void incorporarTema(Tema tema) {
		temaDao.create(tema);
	}

}
