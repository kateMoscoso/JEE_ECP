package es.miw.upm.web.design.views.beans;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.web.controllers.IncorporarTemaController;
@ManagedBean
public class IncorporarTemaView {
	private String errorMsg;
	private Tema tema;
	private IncorporarTemaController incorporarTemaController;

	public IncorporarTemaView() {
		incorporarTemaController = new IncorporarTemaController();
		tema = new Tema();
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
		LogManager.getLogger(IncorporarTemaView.class).info("Se va a añadir el tema: "+ tema.getNombre());
		return "home";
	}
}
