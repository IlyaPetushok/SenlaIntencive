package project.vapeshop.dao;

import java.util.List;

public interface Dao<T,C> {
    boolean createObject(T t);
    boolean createObjects(List<T> t);
    List<T> gelAllObjects();
    T getByIdObject(C id);
    T update(T t);
    boolean delete(C id);
}
