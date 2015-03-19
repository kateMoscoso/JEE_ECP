package es.miw.upm.web.design.views.beans;

import java.util.Map;

import es.miw.upm.web.controllers.VerVotacionesController;

public class VerVotacionesView {
	private Map<String, Integer> votaciones; 
	private Map<String, Double> medias;

	private VerVotacionesController verVotacionesController;
	public VerVotacionesView(){
		verVotacionesController = new VerVotacionesController();
	}
	public void update() {
		votaciones = verVotacionesController.obtenerNumeroVotos();
		medias = verVotacionesController.getMediaVotos();
	}
	public Map<String, Integer> getVotaciones() {
		return votaciones;
	}
	public void setVotaciones(Map<String, Integer> votaciones) {
		this.votaciones = votaciones;
	}
	public Map<String, Double> getMedias() {
		return medias;
	}
	public void setMedias(Map<String, Double> medias) {
		this.medias = medias;
	}

}
