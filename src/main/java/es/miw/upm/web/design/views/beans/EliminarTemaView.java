package es.miw.upm.web.design.views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.web.controllers.EliminarTemaController;

@ManagedBean
public class EliminarTemaView {
	private String errorMsg;
	private Integer idtema;
	private List<Tema> temas;
	private String codigo;
	private Integer flag =-1;


	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	private EliminarTemaController eliminarTemaController;

	public EliminarTemaView() {
		eliminarTemaController = new EliminarTemaController();
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

	public Integer getIdtema() {
		return idtema;
	}

	public void setIdtema(Integer idtema) {
		this.idtema = idtema;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void update() {
		LogManager.getLogger(EliminarTemaView.class).debug(
				"Se accede a la capa de negocio para recuperar los temas");
		temas = eliminarTemaController.obtenerTemas();
	}

	public String process() {
		String view = "home";
		if (flag==2) {
			eliminarTemaController.eliminarTema(idtema);
			view = "home";
		}
		else if (eliminarTemaController.comporbarAutorizacion(codigo)) {
			flag = 2;
			view = "eliminarTema";
		}
		else {
			flag =-1;
			errorMsg ="Valor introducido incorrectamente";
			view = "eliminarTema";
		}
		
		return view;
	}
}
