package es.miw.upm.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class VerVotacionesController extends Controller {
	private VotoDao daoVoto;
	private List<Tema> temas;
	private Map<String, Integer> votaciones = new HashMap<String, Integer>();
	private Map<String, Double> listaMedias = new HashMap<String, Double>();

	public VerVotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		daoVoto = DaoFactory.getFactory().getVotoDao();
		temas = obtenerTemas();
	}

	public Map<String, Integer> obtenerNumeroVotos() {
		for (Tema t : temas) {
			votaciones.put(t.getNombre(), t.getVotos().size());
			System.out.println(t.getNombre());
		}
		return votaciones;
	}

	public Map<String, Double> getMediaVotos() {
		for (NivelEstudiosType n : NivelEstudiosType.values()) {
			listaMedias.put(n.name(), getMedia(n));
			System.out.println(n.name());
		}
		return listaMedias;
	}

	public double getMedia(NivelEstudiosType nivel) {
		List<Voto> votos = daoVoto.findAll();
		int puntuaciones = 0;
		int contador = 0;
		double media = 0.0;
		for (Voto v : votos) {
			if (nivel.equals(v.getNivelEstudiosType())) {
				contador++;
				puntuaciones += v.getValor();
			}
		}
		if(puntuaciones>0.0){
			media = puntuaciones/contador;
		}
		return media;
	}

}
