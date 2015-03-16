package es.miw.upm.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class VerVotacionesController extends Controller {
	private TemaDao temaDao;
	private List<Tema> temas;
	private int [] medias;
	private Map<String, Integer> votaciones = new HashMap<String, Integer>();
	private Map<String, Integer[]> listaMedias = new HashMap<String, Integer[]>();
	public VerVotacionesController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		temas = obtenerTemas();
	}
	public Map<String, Integer> getNumeroVotos(){

		for (Tema t: temas) {
			votaciones.put(t.getNombre(), t.getVotos().size());
		}
		return votaciones;
	}
	public void getMediaVotos(){
		medias = new int[NivelEstudiosType.values().length];
		int i = 0;
		for (Tema t: temas) {
		}

	}
	public int getMedia(NivelEstudiosType nivel, Tema t){
		List<Voto> votos = t.getVotos();
		int contador = 0;
		int media = 0;
		for (Voto v : votos) {
			if(nivel.equals(v.getNivelEstudiosType())){
				contador++;
				media+=v.getValor();
			}
		}
		return media/contador;
	}


}
