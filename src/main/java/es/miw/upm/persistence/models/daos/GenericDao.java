package es.miw.upm.persistence.models.daos;

import java.util.List;
/**
 * 
 * @author Katherin Moscoso Le�n
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDao<T, ID> {

    void create(T entity);

    T read(ID id);

    void update(T entity);

    void deleteById(ID id);

    List<T> findAll();

}
