package es.miw.upm.web.controllers;

import java.util.List;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Voto;

public class EliminarTemaController extends Controller {
	private TemaDao daoTema;
	private VotoDao daoVoto;
	private List<Voto> votos;
	public static String CODIGO="666";

	public EliminarTemaController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoFactory.getFactory().getTemaDao();
		daoVoto = DaoFactory.getFactory().getVotoDao();
	}

	public void eliminarTema(Integer id) {

		votos = daoTema.read(id).getVotos();
		for (Voto voto : votos) {
			daoVoto.deleteById(voto.getIdVoto());
		}
		daoTema.deleteById(id);
	}
	public boolean comprobarAutorizacion(String codigo){
		return codigo.equals(CODIGO);
	}

}
