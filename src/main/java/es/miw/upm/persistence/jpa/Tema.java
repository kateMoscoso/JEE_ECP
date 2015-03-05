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
public class Tema {
	@Id
	private Integer idTema;

	private String nombre;
	private String pregunta;
	private Integer valorPuntuacion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tema")
	private List<Voto> votos;
	public Tema(){
		super();
	}
	public Tema(Integer id, String nombre, String pregunta, Integer valorPuntuacion){
		super();
		this.idTema = id;
		this.nombre = nombre;
		this.pregunta = pregunta;
		this.valorPuntuacion = valorPuntuacion;
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
	public String getValorPuntuacion() {
		return this.pregunta;
	}

	public void setValorPuntuacion(Integer ValorPuntuacion) {
		this.valorPuntuacion = ValorPuntuacion;
	}
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Tema [id=" + idTema + ", nombre=" + nombre + ", votos=" + votos + "]";
	}
	public static void main(String[] args) {

		JpaFactory.dropAndCreateTables();
		EntityManager em = JpaFactory.getEntityManagerFactory().createEntityManager();
		Tema tema1 = new Tema(1, "RollingStones", "¿Como puntuarias a los RollingStones?",5);
		Tema tema2 = new Tema(2, "Muse", "¿Como puntuarias a Muse en directo?",6);

		List<Voto> votos = new ArrayList<Voto>();
		votos.add(new Voto("100.20.2.2", tema1, NivelEstudiosType.BASICO));
		votos.add(new Voto("100.20.2.5", tema1, NivelEstudiosType.INTERMEDIO));
		tema1.setVotos(votos);
		// Create
		em.getTransaction().begin();
		em.persist(tema1);
		em.persist(tema2);
		em.getTransaction().commit();
		// find
		System.out.println(em.find(Tema.class, 1));
		System.out.println(em.find(Tema.class, 2));
		System.out.println(em.find(Tema.class, 3));
	}


}
