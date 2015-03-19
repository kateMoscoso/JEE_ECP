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
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private List<Tema> temas;
	private String[] nivelEstudios;
	private VotarController votarController;
	private Integer[] puntuacionValores;
	private Integer flag = -1;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

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
		nivelEstudios = new String[NivelEstudiosType.values().length];
		int i = 0;
		for (NivelEstudiosType e : NivelEstudiosType.values()) {
			nivelEstudios[i] = e.toString();
			i++;
		}
		puntuacionValores = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	}

	public String process() {
		String view = "votar";
		System.out.println("el flag en view es: " + this.flag);
		if (this.getId() != null) {
			tema = votarController.obtenerTema(id);
			if (this.getFlag() == 2) {
				System.out.println(voto.toString());
				System.out.println(tema.toString());
				votarController.añadirVoto(tema, voto);
				view = "home";
				this.flag = -1;
			}
		}
		return view;
	}

}
