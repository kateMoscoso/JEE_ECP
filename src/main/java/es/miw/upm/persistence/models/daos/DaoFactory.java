package es.miw.upm.persistence.models.daos;

/**
 * 
 * @author Katherin Moscoso Le�n
 *
 */

public abstract class DaoFactory {
	 public static DaoFactory factory = null;

	    public static void setFactory(DaoFactory factory) {
	        DaoFactory.factory = factory;
	    }

	    public static DaoFactory getFactory() {
	        assert factory != null;
	        return factory;
	    }

	    public abstract TemaDao getTemaDao();

	    public abstract VotoDao getVotoDao();

}
