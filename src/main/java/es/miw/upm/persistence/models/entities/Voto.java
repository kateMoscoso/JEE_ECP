package es.miw.upm.persistence.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jdbc.DaoJdbcFactory;


@Entity
@Table(name = Voto.TABLE)
public class Voto {
	public static final String TABLE = "voto";

	public static final String ID = "ID";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private Integer id;

	public static final String IP = "IP";
//	@Column(name = IP)
	private String ip;

	public static final String VALOR = "VALOR";
//	@Column(name = VALOR)
	private Integer valor;

	public static final String NIVELESTUDIOS = "NIVELESTUDIOS";
//
	@Enumerated(EnumType.STRING) // Opcional
	private NivelEstudiosType nivelEstudiosType;


	public Voto(String ip, NivelEstudiosType nivelEstudios, Integer valor) {
		this.ip = ip;
		this.nivelEstudiosType = nivelEstudios;
		this.valor = valor;
	}

	public Voto() {
	}

	public Integer getIdVoto(){
		return id;
	}
	public void setIdVoto(Integer id){
		this.id= id;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public NivelEstudiosType getNivelEstudiosType() {
		return nivelEstudiosType;
	}

	public void setNivelEstudiosType(NivelEstudiosType nivelEstudios) {
		nivelEstudiosType = nivelEstudios;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		Voto other = (Voto) obj;
		boolean result = id.equals(other.id) && ip.equals(other.ip)
				&& nivelEstudiosType.equals(other.nivelEstudiosType) && valor.equals(other.valor);
		return result;

	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ip= " + ip+ ", valor=" +valor 
				+ ", nivel de estudios= " + nivelEstudiosType +" ]";
	}
	public void testJDBC() {
		VotoDao dao;
		Voto voto, voto2;
		DaoFactory.setFactory(new DaoJdbcFactory());
		DaoJdbcFactory.dropAndCreateTables();
		voto= new Voto("100.20.2.8",NivelEstudiosType.BASICO,10);
		voto2= new Voto("100.20.3.8",NivelEstudiosType.BASICO,10);
		dao = DaoFactory.getFactory().getVotoDao();
		System.out.println(voto.toString());
		System.out.println(dao.toString());
		dao.create(voto);
		dao.create(voto2);
		System.out.println(dao.read(1));
		System.out.println(dao.findAll());
		voto.setIp("100.20.3.9");
		voto.setIdVoto(1);
		dao.update(voto);
		dao.deleteById(2);
		System.out.println(dao.findAll());
	}
	
}
