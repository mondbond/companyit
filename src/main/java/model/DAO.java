package model;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by User on 30.09.2017.
 */
public interface DAO<T> {

    void add(T model) throws SQLException;

    T getById(int id);
    void deleteById(int id);

    void save (T model);
    void edit (T model);
    void delete(T model);

    List<T> getAll();
}
