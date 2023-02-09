package project.vapeshop.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, С> {
    boolean insertObject(T t);

    boolean insertObjects(List<T> t);

    List<T> selectObjects();

    T selectObject(С id);

    T update(T t);

    boolean delete(С id);
}
