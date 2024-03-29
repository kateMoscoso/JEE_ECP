package es.miw.upm.web.controllers;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class VotarController extends Controller {
	private TemaDao daoTema;
	private VotoDao daoVoto;
	private Voto voto;
	public VotarController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoFactory.getFactory().getTemaDao();
		daoVoto = DaoFactory.getFactory().getVotoDao();
	}
	public void addVoto(Tema t, Voto v){
		voto = new Voto(v.getIp(),v.getNivelEstudiosType(),v.getValor());
		daoVoto.create(voto);
		t.getVotos().add(voto);
		daoTema.update(t);
	}
	public Tema obtenerTema(int id){
		return daoTema.read(id);
	}
	public Integer []  obtenerValoresVotacion(){
		return new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	}
	public String[] obtenerNivelEstudios(){
		String [] nivelEstudios = new String[NivelEstudiosType.values().length];
		int i = 0;
		for (NivelEstudiosType e : NivelEstudiosType.values()) {
			nivelEstudios[i] = e.toString();
			i++;
		}
		return nivelEstudios;
	}
	public String obtenerIP(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
		return request.getRemoteAddr();		
	}

}
