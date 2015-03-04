package es.miw.upm.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;

@Entity
public class Voto {
	@Id
    @GeneratedValue
    private Integer idVoto;

	private String ip;

    @Enumerated(EnumType.STRING)
    private NivelEstudiosType nivelEstudios ;

    @ManyToOne
    @JoinColumn
    private Tema tema;
    
    public Voto(){}

    public Voto(Integer id, String ip, Tema tema) {
        this.idVoto = id;
        this.ip = ip;
        this.tema = tema;
    }
    public Integer getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(Integer idVoto) {
		this.idVoto = idVoto;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public NivelEstudiosType getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudiosType nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	@Override
    public String toString() {
        return "Vehicle [id=" + idVoto+  ", ip=" + ip + 
        	 "nivelEstudios=" +nivelEstudios +", temaId=" + tema.getId() + "]";
    }
}
