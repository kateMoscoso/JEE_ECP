package es.miw.upm.web.controllers;

import java.util.List;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;

public class VerVotacionesController {
	private TemaDao temaDao;
	public VerVotacionesController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
	}
	public List<Tema> obtenerTemas(){
		return temaDao.findAll();
	}


}
