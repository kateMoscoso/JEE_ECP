package es.miw.upm.web.controllers;

import java.util.ArrayList;
import java.util.List;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class VotarController {
	private TemaDao temaDao;
	private VotoDao votoDao;
	private Tema tema;
	private List<Voto> votos;
	public VotarController(){
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();

	}
	public List<Tema> obtenerTemas(){
		return temaDao.findAll();
	}
	public void añadirVoto(Tema tema, Voto voto){
		votoDao.create(voto);
		tema = temaDao.read(tema.getId_tema());
		if(tema.getVotos().size()>0){
			votos = tema.getVotos();
			votos.add(voto);
			tema.setVotos(votos);
		}
		else {
			votos = new ArrayList<Voto>();
			votos.add(voto);
		}
		tema.setVotos(votos);
		temaDao.update(tema);
	}


}
