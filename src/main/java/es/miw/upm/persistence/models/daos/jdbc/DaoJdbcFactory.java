package es.miw.upm.persistence.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.miw.upm.persistence.models.daos.DaoFactory;
import es.miw.upm.persistence.models.daos.TemaDao;
import es.miw.upm.persistence.models.daos.VotoDao;
import es.miw.upm.persistence.models.entities.Tema;
import es.miw.upm.persistence.models.entities.Voto;

public class DaoJdbcFactory extends DaoFactory {
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/miwjee";

	private static final String USER = "root";

	private static final String PASS = "";

	private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

	private static Connection connection;

	public static Connection getConnection() {
		try {
			if (connection == null || !connection.isValid(0)) {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("no se ha conectado");
		} catch (SQLException e) {
			// LogManager.getLogger(DaoJdbcFactory.class).error(
			// "Problemas con la BD: " + e.getMessage());
		}
		return connection;
	}

	public static void dropAndCreateTables() {
		try {
			Statement statement = getConnection().createStatement();
//			statement.executeUpdate(String.format(DROP_TABLE, Tema.TABLE));
			statement.executeUpdate(String.format(DROP_TABLE, Voto.TABLE));
			// statement.executeUpdate(String.format(DROP_TABLE,
			// Category.TABLE));
			// statement.executeUpdate(CategoryDaoJdbc.sqlToCreateTable());
//			statement.executeUpdate(TemaDaoJdbc.sqlToCreateTable());
			statement.executeUpdate(VotoDaoJdbc.sqlToCreateTable());
		} catch (SQLException e) {
			System.out.println("error");
		}
	}

	@Override
	public TemaDao getTemaDao() {
		// TODO Auto-generated method stub
		return new TemaDaoJdbc();
	}

	@Override
	public VotoDao getVotoDao() {
		// TODO Auto-generated method stub
		return new VotoDaoJdbc();
	}

}
