package es.miw.upm.web.design.views.beans;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.web.controllers.EliminarTemaController;

public class EliminarTemaView {
	private String errorMsg;
	private Tema tema;
	private EliminarTemaController eliminarTemaController;

	public EliminarTemaView() {
		eliminarTemaController = new EliminarTemaController();
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
		eliminarTemaController.eliminarTema(tema);
		return "home";
	}
}
