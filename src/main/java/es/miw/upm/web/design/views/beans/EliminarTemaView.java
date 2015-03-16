package es.miw.upm.web.design.views.beans;


import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.web.controllers.EliminarTemaController;

public class EliminarTemaView {
	private String errorMsg;
	private Tema tema;
	private List<Tema> temas;
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

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public void update() {
		 LogManager.getLogger(EliminarTemaView.class).debug(
	                "Se accede a la capa de negocio para recuperar los temas");
		temas = eliminarTemaController.obtenerTemas();

	}
	public String process() {
		eliminarTemaController.eliminarTema(tema);
		return "home";
	}
}
