package es.miw.upm.persistence.jpa;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tema {
	@Id
	private Integer idTema;

	private String nombre;
	private String pregunta;
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "tema")
	private List<Voto> votos;
	public Tema(){
		super();
	}
	public Tema(Integer id, String nombre, String pregunta){
		super();
		this.idTema = id;
		this.nombre = nombre;
		this.pregunta = pregunta;
	}
	public Integer getId() {
		return this.idTema;
	}

	public void setId(Integer id) {
		this.idTema = id;
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
	public List<Voto> getVotos() {
		return votos;
	}

	public void setVehicles(List<Voto> votos) {
		this.votos = votos;
	}
	
	@Override
    public String toString() {
        return "Tema [id=" + idTema + ", nombre=" + nombre + ", votos=" + votos + "]";
    }


}
