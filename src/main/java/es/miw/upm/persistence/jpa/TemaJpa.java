package es.miw.upm.persistence.jpa;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;


@Entity
public class TemaJpa {
	@Id
	private Integer idTema;

	private String nombre;
	private String pregunta;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tema")
	private List<VotoJpa> votos;
	public TemaJpa(){
		super();
	}
	public TemaJpa(Integer id, String nombre, String pregunta){
		super();
		this.idTema = id;
		this.nombre = nombre;
		this.pregunta = pregunta;
		
	}
	public Integer getIdTema() {
		return this.idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<VotoJpa> getVotos() {
		return votos;
	}

	public void setVotos(List<VotoJpa> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Tema [id=" + idTema + ", nombre=" + nombre + ", votos=" + votos + "]";
	}
	public static void main(String[] args) {

		JpaFactory.dropAndCreateTables();
		EntityManager em = JpaFactory.getEntityManagerFactory().createEntityManager();
		TemaJpa tema1 = new TemaJpa(1, "RollingStones", "¿Como puntuarias a los RollingStones?");
		TemaJpa tema2 = new TemaJpa(2, "Muse", "¿Como puntuarias a Muse en directo?");

		List<VotoJpa> votos = new ArrayList<VotoJpa>();
		votos.add(new VotoJpa("100.20.2.2", tema1, NivelEstudiosType.BASICO, 5));
		votos.add(new VotoJpa("100.20.2.5", tema1, NivelEstudiosType.INTERMEDIO, 6));
		tema1.setVotos(votos);
		// Create
		em.getTransaction().begin();
		em.persist(tema1);
		em.persist(tema2);
		em.getTransaction().commit();
		// find
		System.out.println(em.find(TemaJpa.class, 1));
		System.out.println(em.find(TemaJpa.class, 2));
		System.out.println(em.find(TemaJpa.class, 3));
		System.out.println(em.find(TemaJpa.class, 1).getVotos().size());
		em.getTransaction().begin();
		em.remove(em.find(TemaJpa.class, 1));
		em.getTransaction().commit();
		System.out.println(em.find(TemaJpa.class, 1));
	}


}
