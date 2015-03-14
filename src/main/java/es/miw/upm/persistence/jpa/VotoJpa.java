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
public class VotoJpa {
	@Id
    @GeneratedValue
    private Integer idVoto;

	private String ip;

	private Integer valorPuntuacion;

    @Enumerated(EnumType.STRING)
    private NivelEstudiosType nivelEstudios ;

    @ManyToOne
    @JoinColumn
    private TemaJpa tema;
    
    public VotoJpa(){}

    public VotoJpa(String ip, TemaJpa tema, NivelEstudiosType nivel, Integer valorPuntuacion) {
        this.ip = ip;
        this.tema = tema;
        this.nivelEstudios = nivel;
        this.valorPuntuacion = valorPuntuacion;
    }
    public Integer getIdVoto() {
		return idVoto;
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

	public TemaJpa getTema() {
		return tema;
	}

	public void setTema(TemaJpa tema) {
		this.tema = tema;
	}
	public Integer getValorPuntuacion() {
		return this.valorPuntuacion;
	}

	public void setValorPuntuacion(Integer ValorPuntuacion) {
		this.valorPuntuacion = ValorPuntuacion;
	}
	
	@Override
    public String toString() {
        return "Vehicle [id=" + idVoto+  ", ip=" + ip + 
        	 " nivelEstudios=" +nivelEstudios +", temaId=" + tema.getIdTema() + 
        	 ", valor= " + valorPuntuacion + "]";
    }
}
