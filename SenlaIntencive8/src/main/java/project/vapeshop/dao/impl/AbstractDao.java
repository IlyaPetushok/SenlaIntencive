package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public abstract class AbstractDao<T extends EntityId,C> implements Dao<T,C> {
    private static final int BATCH_SIZE=10;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public T insertObject(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public List<T> insertObjects(List<T> t) {
        for (int i = 0; i < t.size(); i++) {
            if ( i>0 && i % BATCH_SIZE == 0){
                entityManager.flush();
                entityManager.clear();
            }
            entityManager.persist(t.get(i));
        }
        return selectObjects();
    }


    public abstract List<T> selectObjects();

    public abstract T selectObject(C id);

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public boolean delete(C id) {
        T t=selectObject(id);
        entityManager.remove(t);
        return true;
    }
}
