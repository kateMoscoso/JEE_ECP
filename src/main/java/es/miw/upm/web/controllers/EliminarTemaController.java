package es.miw.upm.web.controllers;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;

public class EliminarTemaController {
	private TemaDao temaDao;
	public EliminarTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();

	}
	public void eliminarTema(Tema tema){
		temaDao.deleteById(tema.getId_tema());
	}

}
