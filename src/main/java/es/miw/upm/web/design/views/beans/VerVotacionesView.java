package es.miw.upm.web.design.views.beans;

import java.util.List;
import java.util.Map;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.web.controllers.VerVotacionesController;

public class VerVotacionesView {
	private List<Tema> temas; 
	private Map<String, Integer> votaciones;
	private VerVotacionesController verVotacionesController;
	public VerVotacionesView(){
		verVotacionesController = new VerVotacionesController();
	}
	public void update() {
		temas = verVotacionesController.obtenerTemas();
		votaciones = verVotacionesController.getNumeroVotos();
	}
	public Map<String, Integer> getVotaciones() {
		return votaciones;
	}
	public void setVotaciones(Map<String, Integer> votaciones) {
		this.votaciones = votaciones;
	}

}
