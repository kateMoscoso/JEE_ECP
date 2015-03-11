package es.miw.upm.persistence.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;


@Entity
@Table(name = VotoEntity.TABLE)
public class VotoEntity {
	  public static final String TABLE = "VOTO";

	    public static final String IDVOTO = "IDVOTO";

	    @Id
	    @GeneratedValue
	    @Column(name = IDVOTO)
	    private Integer idVoto;

	    public static final String IP = "IP";
	    @Column(name = IP)
	    private String ip;
	    
	    public static final String VALOR = "VALOR";
	    @Column(name = VALOR)
	    private Integer valor;

	    public static final String NIVELESTUDIOS = "NIVELESTUDIOS";

	    @Enumerated(EnumType.STRING) // Opcional
	    private NivelEstudiosType NivelEstudiosType;

	    public static final String ID = "TEMA_ID";

	    @ManyToOne
	    @JoinColumn(name = ID)
	    private TemaEntity temaEntity;
 
	    public VotoEntity(String ip, NivelEstudiosType nivelEstudios, Integer valor) {
	        this.ip = ip;
	        this.NivelEstudiosType = nivelEstudios;
	        this.valor = valor;
	    }

	    public VotoEntity() {
	    }

	   
}
