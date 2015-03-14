package es.miw.upm.persistence.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.miw.upm.persistence.jpa.JpaFactory;
import es.miw.upm.persistence.jpa.TemaJpa;
import es.miw.upm.persistence.jpa.VotoJpa;
import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jdbc.DaoJdbcFactory;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;

@Entity
public class Tema {
	public static final String TABLE = "tema";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer idTema;

	public static final String NOMBRE = "NOMBRE";
	private String nombre;

	public static final String PREGUNTA = "PREGUNTA";
	private String pregunta;

	// Relación unidireccional: 1:0..n
	// relación mapeada en una tabla de unión
	// Se aplica cascada
	@OneToMany(cascade = CascadeType.ALL)
	private List<Voto> votos;

	public Tema(){}
	public Tema(String nombre, String pregunta){
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	public Integer getId_tema() {
		return idTema;
	}
	public void setId_tema(Integer id_tema) {
		this.idTema = id_tema;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		Tema other = (Tema) obj;
		boolean result = idTema.equals(other.idTema) && nombre.equals(other.nombre)
				&& pregunta.equals(other.pregunta);
		return result;

	}

	@Override
	public String toString() {
		return "Tema [id=" + idTema + ", nombre=" + nombre + ", pregunta=" +pregunta 
				+ ", votos=" + votos.toString() + " ]";
	}
	public static void main(String[] args) {
		DaoFactory.setFactory(new DaoJpaFactory());
		JpaFactory.dropAndCreateTables();
		Tema tema = new Tema("RollingStones", "�Como puntuarias a los RollingStones?");
//		voto = new VotoEntity("100.20.2.8", NivelEstudiosType.BASICO,10);
		//tema.setVotos(votos);

		TemaDao daoTema = DaoFactory.getFactory().getTemaDao();
		daoTema.create(tema);
	}

	
}
