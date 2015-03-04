package es.miw.upm.persistence.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TemaEntity {
	public static final String TABLE = "tema";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id_tema;

	public static final String NOMBRE = "NOMBRE";
	private String nombre;

	public static final String PREGUNTA = "PREGUNTA";
	private String pregunta;

	// Relación bidireccional: 1:0..n
	// relación mapeada en la otra entidad
	@OneToMany(mappedBy = "temaEntity")
	private List<VotoEntity> votos;

	public TemaEntity(){}
	public TemaEntity(String nombre, String pregunta){
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	public Integer getId_tema() {
		return id_tema;
	}
	public void setId_tema(Integer id_tema) {
		this.id_tema = id_tema;
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
	public List<VotoEntity> getVotos() {
		return votos;
	}

	public void setVotos(List<VotoEntity> votos) {
		this.votos = votos;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		TemaEntity other = (TemaEntity) obj;
		boolean result = id_tema.equals(other.id_tema) && nombre.equals(other.nombre)
				&& pregunta.equals(other.pregunta);
		return result;

	}

	@Override
	public String toString() {
		return "Tema [id=" + id_tema + ", nombre=" + nombre + ", pregunta=" +pregunta 
				+ ", votos=" + votos + "]";
	}

}
