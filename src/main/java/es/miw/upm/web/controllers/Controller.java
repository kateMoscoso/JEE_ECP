package es.miw.upm.web.controllers;

import java.util.List;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;

public class Controller {
	private TemaDao daoTema;
	public Controller(){
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoFactory.getFactory().getTemaDao();

	}
	public List<Tema> obtenerTemas(){
		return daoTema.findAll();
	}

}
