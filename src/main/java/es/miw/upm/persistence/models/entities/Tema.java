package es.miw.upm.persistence.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tema {
	public static final String TABLE = "tema";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	@Column(name = ID)
	private Integer idTema;

	public static final String NOMBRE = "NOMBRE";
	private String nombre;

	public static final String PREGUNTA = "PREGUNTA";
	private String pregunta;

	// Relación unidireccional: 1:0..n
	// relación mapeada en una tabla de unión
	// Se aplica cascada
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Voto> votos;

	public Tema(){}
	public Tema(String nombre, String pregunta){
		this.nombre = nombre;
		this.pregunta = pregunta;
		votos = new ArrayList<Voto>();
	}

	public Integer getIdTema() {
		return idTema;
	}
	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
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
	
	public void getMedias(){
		
	}


}
