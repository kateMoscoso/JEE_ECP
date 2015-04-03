package es.miw.upm.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.miw.upm.persistence.model.utils.NivelEstudiosType;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.entities.Voto;

public class VotoDaoJdbc extends GenericDaoJdbc<Voto, Integer> implements VotoDao {
	 private Logger log = LogManager.getLogger(VotoDaoJdbc.class);

	private Voto create(ResultSet resultSet) {
		Voto voto;
		try {
			if (resultSet != null && resultSet.next()) {
				voto= new Voto(resultSet.getString(Voto.IP),
						(NivelEstudiosType)resultSet.getObject(Voto.NIVELESTUDIOS),
						resultSet.getInt(Voto.VALOR));
				 voto.setIdVoto(resultSet.getInt(Voto.ID));
				 return voto;
			}
		} catch (SQLException e) {
						log.error("read: " + e.getMessage());
		}
		return null;
	}

	private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL AUTO_INCREMENT , %s VARCHAR(255),%s VARCHAR(255), "
			+ "%s INT,  PRIMARY KEY (%s))";

	public static String sqlToCreateTable() {
		return String.format(SQL_CREATE_TABLE, Voto.TABLE, Voto.ID, Voto.IP, 
				Voto.NIVELESTUDIOS, Voto.VALOR, Voto.ID);
	}

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s, %s) VALUES ('%s','%s', %d)";

	@Override
	public void create(Voto voto) {
		this.updateSql(String.format(SQL_INSERT, Voto.TABLE,  Voto.IP, 
				Voto.NIVELESTUDIOS, Voto.VALOR, voto.getIp(), voto.getNivelEstudiosType(), voto.getValor()));
	}

	@Override
	public Voto read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Voto.TABLE, id));
		return this.create(resultSet);
	}

	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s', %s='%s' WHERE ID=%d";

	@Override
	public void update(Voto voto) {
		this.updateSql(String.format(SQL_UPDATE, Voto.TABLE, Voto.IP, voto.getIp(),
				Voto.NIVELESTUDIOS, voto.getNivelEstudiosType(), Voto.VALOR,
				voto.getValor(), voto.getIdVoto()));
	}

	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Voto.TABLE, id));
	}

	@Override
	public List<Voto> findAll() {
		List<Voto> list = new ArrayList<Voto>();
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Voto.TABLE));
		Voto voto = this.create(resultSet);
		while (voto != null) {
			list.add(voto);
			voto = this.create(resultSet);
		}
		return list;
	}

}
