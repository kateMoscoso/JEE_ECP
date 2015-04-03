package es.miw.upm.web.design.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;
import es.miw.upm.web.controllers.VotarController;

@ManagedBean
@SessionScoped
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
		tema = new Tema();
		voto = new Voto();
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
		nivelEstudios = votarController.obtenerNivelEstudios();
		puntuacionValores = votarController.obtenerValoresVotacion();
	}

	public String obtenerDatosTema() {
		String view = "votar";
		if (this.getId() != null) {
			tema = votarController.obtenerTema(id);
		}
		return view;
	}
	public String votarTema() {
		String view = "votar";
			tema = votarController.obtenerTema(id);
			if (voto.getNivelEstudiosType()!=null) {
				if (voto.getIp() == null) {
					voto.setIp(votarController.obtenerIP());
				}
				votarController.addVoto(tema, voto);
				view = "home";
			}
		return view;
	}
}
