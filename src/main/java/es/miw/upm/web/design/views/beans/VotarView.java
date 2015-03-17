package es.miw.upm.web.design.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;
import es.miw.upm.web.controllers.VotarController;

public class VotarView {
	private String errorMsg;
	private Tema tema;
	private Voto voto;
	private List<Tema> temas;
	private String[] nivelEstudios;
	private VotarController votarController;
	private Integer [] puntuacionValores;

	public VotarView() {
		votarController = new VotarController();
	}

	public String getErrorMsg() {
		return errorMsg;
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
	                "Se accede a la capa de negocio para recuperar roles");
		temas = votarController.obtenerTemas();
		nivelEstudios = new String [NivelEstudiosType.values().length];
		int i = 0;
		for (NivelEstudiosType e: NivelEstudiosType.values()) {
			nivelEstudios[i]= e.toString();
			i++;
		}
		puntuacionValores = new Integer [] {0,1,2,3,4,5,6,7,8,9,10};
	}


	public String process() {
		
//if(thi)
		//		if (this.voto.getIdVoto() == 666
		//				&& !this.persona.getNombre().equals("Demonio")) {
		//			this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
		//			return "persona";
		//		} else {
//					LogManager.getLogger(VotarView.class).debug(
//							"Se accede a la capa de negocio para registrar persona: "
//									+ tema.getNombre()+ tema.getPregunta());
		return "votarTema";
	}

}
