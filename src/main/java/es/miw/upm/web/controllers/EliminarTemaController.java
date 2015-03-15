package es.miw.upm.web.controllers;

import java.util.List;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class EliminarTemaController {
	private TemaDao daoTema;
	private VotoDao daoVoto;
	private List<Voto> votos;
	public EliminarTemaController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoFactory.getFactory().getTemaDao();
		daoVoto = DaoFactory.getFactory().getVotoDao();
	}
	public void eliminarTema(Tema tema){
		votos = tema.getVotos();
		daoTema.deleteById(tema.getId_tema());
		for (Voto voto : votos) {
			daoVoto.deleteById(voto.getIdVoto());
		}
	}

}