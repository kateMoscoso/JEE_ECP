package es.miw.upm.web.design.views.beans;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.web.controllers.IncorporarTemaController;

public class IncorporarTemaView {
	private String errorMsg;
	private Tema tema;
	private IncorporarTemaController incorporarTemaController;

	public IncorporarTemaView() {
		incorporarTemaController = new IncorporarTemaController();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}


	public String process() {
		incorporarTemaController.incorporarTema(tema);
		return "home";
	}
}
