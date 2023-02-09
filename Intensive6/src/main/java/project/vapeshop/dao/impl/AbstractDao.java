package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityId;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AbstractDao<T extends EntityId,C> implements Dao<T,C> {
    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    @Override
    public boolean insertObject(T t) {
        entityManager.merge(t);
        return true;
    }

    @Override
    public boolean insertObjects(List<T> t) {
        for (T t1 : t) {
            insertObject(t1);
        }
        return true;
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

    @Transactional
    @Override
    public boolean delete(C id) {
        entityManager.remove(selectObject(id));
        return true;
    }
}
