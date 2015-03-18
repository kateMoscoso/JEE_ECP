package es.miw.upm.web.controllers;

import java.util.ArrayList;
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
	private List<Voto> votos;
	public VotarController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoFactory.getFactory().getTemaDao();
		daoVoto = DaoFactory.getFactory().getVotoDao();

	}

	public void añadirVoto(Tema tema, Voto voto){
		daoVoto.create(voto);
		this.tema = daoTema.read(tema.getIdTema());
		if(tema.getVotos().size()>0){
			votos = tema.getVotos();
			votos.add(voto);
			tema.setVotos(votos);
		}
		else {
			votos = new ArrayList<Voto>();
			votos.add(voto);
		}
		this.tema.setVotos(votos);
		daoTema.update(tema);
	}
	public Tema obtenerTema(int id){
		return daoTema.read(id);
	}

}
