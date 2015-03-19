package es.miw.upm.web.controllers;
import java.util.List;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class VotarController extends Controller {
	private TemaDao daoTema;
	private VotoDao daoVoto;
	private Tema tema;
	private Voto voto;
	private List<Voto> votos;
	public VotarController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoFactory.getFactory().getTemaDao();
		daoVoto = DaoFactory.getFactory().getVotoDao();

	}

	public void añadirVoto(Tema tema, Voto voto){		
//		this.tema = daoTema.read(tema.getIdTema());
		System.out.println(tema.getVotos());
		this.voto = new Voto(voto.getIp(),voto.getNivelEstudiosType(), voto.getValor());
		daoVoto.create(this.voto);
		tema.getVotos().add(voto);
		daoTema.update(tema);
	}
	public Tema obtenerTema(int id){
		return daoTema.read(id);
	}

}
