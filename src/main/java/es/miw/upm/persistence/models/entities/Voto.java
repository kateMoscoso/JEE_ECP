package es.miw.upm.persistence.models.entities;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;








import es.miw.upm.persistence.jpa.JpaFactory;
import es.miw.upm.persistence.jpa.TemaJpa;
import es.miw.upm.persistence.jpa.VotoJpa;
import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.daos.jdbc.DaoJdbcFactory;
import es.miw.upm.persistence.models.daos.jpa.DaoJpaFactory;


@Entity
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
	public void testJPA(){
		VotoDao dao;
		Voto voto, voto2;
		DaoFactory.setFactory(new DaoJpaFactory());
//		JpaFactory.dropAndCreateTables();
//		EntityManager em = JpaFactory.getEntityManagerFactory().createEntityManager();
//		TemaJpa tema1 = new TemaJpa(1, "RollingStones", "¿Como puntuarias a los RollingStones?");
		TemaJpa tema2 = new TemaJpa(2, "Muse", "¿Como puntuarias a Muse en directo?");

//		List<VotoJpa> votos = new ArrayList<VotoJpa>();
//		votos.add(new VotoJpa("100.20.2.2", tema1, NivelEstudiosType.BASICO, 5));
//		votos.add(new VotoJpa("100.20.2.5", tema1, NivelEstudiosType.INTERMEDIO, 6));
//		tema1.setVotos(votos);
//		// Create
//		em.getTransaction().begin();
//		em.persist(tema1);
//		em.persist(tema2);
//		em.getTransaction().commit();
//		// find
//		System.out.println(em.find(TemaJpa.class, 1));
//		System.out.println(em.find(TemaJpa.class, 2));
//		System.out.println(em.find(TemaJpa.class, 3));
//		System.out.println(em.find(TemaJpa.class, 1).getVotos().size());
//		em.getTransaction().begin();
//		em.remove(em.find(TemaJpa.class, 1));
//		em.getTransaction().commit();
//		System.out.println(em.find(TemaJpa.class, 1));
	}
	public static void main(String[] args) {}

}
