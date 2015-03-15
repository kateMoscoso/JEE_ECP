package es.miw.upm.web.design.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;
import es.miw.upm.web.controllers.VotarController;

public class VotarView {
	private String errorMsg;
	private Tema tema;
	private Voto voto;
	private List<Tema> temas;
	private String[] roles;
	private VotarController votarController;

	public VotarView() {
		votarController = new VotarController();
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

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	@PostConstruct
	public void update() {
		this.roles = new String[] {"uno", "dos", "tres"};
		this.temas = votarController.obtenerTemas();
	}

	public String process() {

		//		if (this.voto.getIdVoto() == 666
		//				&& !this.persona.getNombre().equals("Demonio")) {
		//			this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
		//			return "persona";
		//		} else {
		//			LogManager.getLogger(PersonaView.class).debug(
		//					"Se accede a la capa de negocio para registrar persona: "
		//							+ persona);
		return "home";
	}

}
