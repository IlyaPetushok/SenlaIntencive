package project.vapeshop.dao;

import java.util.List;

public interface Dao<T> {
    boolean insertObject(T t);
    boolean insertObjects(List<T> t);
    List<T> selectObjects();
    T selectObject(int id);
    T update(T t);
    boolean delete(int id);
}
