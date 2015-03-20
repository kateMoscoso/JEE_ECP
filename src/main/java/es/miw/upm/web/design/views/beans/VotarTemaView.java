package es.miw.upm.web.design.views.beans;

import java.awt.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.models.entities.Voto;
import es.miw.upm.web.controllers.VotarController;

public class VotarTemaView {
	private Voto voto;
	private Integer id;
	private String[] nivelEstudios;
	private VotarController votarController;
	private Integer[] puntuacionValores;
	private Integer flag = -1;

	public VotarTemaView() {
		votarController = new VotarController();
		voto = new Voto();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public String[] getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(String[] nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public Integer[] getPuntuacionValores() {
		return puntuacionValores;
	}

	public void setPuntuacionValores(Integer[] puntuacionValores) {
		this.puntuacionValores = puntuacionValores;
	}

	@PostConstruct
	public void update() {
		LogManager.getLogger(VotarView.class).debug(
				"Se accede a la capa de negocio para recuperar la información necesaria");
		nivelEstudios = votarController.obtenerNivelEstudios();
		puntuacionValores = votarController.obtenerValoresVotacion();
	}

	public String process() {
		String view = "home";		
		votarController.añadirVoto(id, voto);
		return view;
	}



}
