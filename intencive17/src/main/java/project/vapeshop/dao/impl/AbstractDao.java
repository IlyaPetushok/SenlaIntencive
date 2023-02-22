package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityId;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AbstractDao<T extends EntityId,C> implements Dao<T,C> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public T insertObject(T t) {
        return entityManager.merge(t);
    }

    @Override
    public List<T> insertObjects(List<T> t) {
        for (T t1 : t) {
            insertObject(t1);
        }
        return selectObjects();
    }


    @Override
    public List<T> selectObjects() {
        return null;
    }

    @Override
    public T selectObject(C id) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public boolean delete(C id) {
        T t=selectObject(id);
        entityManager.remove(t);
        return true;
    }
}
