package es.miw.upm.web.design.views.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;
import es.miw.upm.web.controllers.EliminarTemaController;
import es.miw.upm.web.controllers.VotarController;
@ManagedBean
public class VotarView {
	private Integer id;

	private List<Tema> temas;
	private VotarController votarController;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public VotarView() {
		votarController = new VotarController();
	}


	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}


	@PostConstruct
	public void update() {
		LogManager.getLogger(VotarView.class).debug(
				"Se accede a la capa de negocio para recuperar los tema a Votar");
		temas = votarController.obtenerTemas();
	}

	public String process() {
		String view = "votarTema/"+id;		
		return view;
	}

}
