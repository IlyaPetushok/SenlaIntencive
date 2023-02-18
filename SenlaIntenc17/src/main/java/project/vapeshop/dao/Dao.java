package project.vapeshop.dao;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface Dao<T, С> {
    T insertObject(T t);

    List<T> insertObjects(List<T> t);

    List<T> selectObjects();

    T selectObject(С id);

    T update(T t);

    boolean delete(С id);
}
