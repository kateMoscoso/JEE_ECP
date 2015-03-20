package es.miw.upm.web.design.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;
import es.miw.upm.web.controllers.VotarController;
@ManagedBean
public class VotarView {
	private String errorMsg;
	private Tema tema;
	private Voto voto;
	private Integer id;
	private List<Tema> temas;
	private String[] nivelEstudios;
	private VotarController votarController;
	private Integer[] puntuacionValores;
	private Integer flag = -1;

	public VotarView() {
		votarController = new VotarController();
	}

	public String getErrorMsg() {
		return errorMsg;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
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

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	

	@PostConstruct
	public void update() {
		LogManager.getLogger(VotarView.class).debug(
				"Se accede a la capa de negocio para recuperar roles");
		temas = votarController.obtenerTemas();
		System.out.println("despues de obtener temas" + temas.size());
		nivelEstudios = votarController.obtenerNivelEstudios();
		System.out.println("despues de obtener Nivel de Estudios" + nivelEstudios.length);
		puntuacionValores = votarController.obtenerValoresVotacion();
		System.out.println("despues de puntuacions" + puntuacionValores.length);
	}

	public String process() {
		String view = "votar";
		System.out.println("el flag en view es: " + this.flag);
		if (this.getId() != null) {
			tema = votarController.obtenerTema(id);
			if (this.getFlag() == 2) {
				System.out.println(voto.toString());
				System.out.println("entra process"+tema.toString());
				votarController.addVoto(tema, voto);
				view = "home";
				this.flag = -1;
			}
		}
		return view;
	}
}
