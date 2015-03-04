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

	    public static final String ID = "ID";

	    @Id
	    @GeneratedValue
	    @Column(name = ID)
	    private Integer idVoto;

	    public static final String IP = "IP";

	    @Column(name = IP)
	    private String ip;

	    public static final String NIVELESTUDIOS = "NIVELESTUDIOS";

	    @Enumerated(EnumType.STRING) // Opcional
	    private NivelEstudiosType NivelEstudiosType;

	    public static final String TEMA_ID = "TEMA_ID";

	    @ManyToOne
	    @JoinColumn(name = TEMA_ID)
	    private TemaEntity temaEntity;
 
	    public VotoEntity(String ip, NivelEstudiosType nivelEstudios) {
	        this.ip = ip;
	        this.NivelEstudiosType = nivelEstudios;
	    }

	    public VotoEntity() {
	    }

	   
}
