package project.vapeshop.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.user.User;
import project.vapeshop.predicate.CustomPredicate;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class AbstractDao<T extends EntityId<?>,C> implements Dao<T,C> {
    private static final int BATCH_SIZE=10;
    private final  Class<T> tClass;

    public AbstractDao() {
        this.tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

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

    @Override
    public Page<T> selectObjectsByFilter(List<CustomPredicate> customPredicates, Pageable pageable) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery= criteriaBuilder.createQuery(tClass);
        Root<T> root= criteriaQuery.from(tClass);
        List<Predicate> predicates=createPredicate(customPredicates,root);
        Predicate finalPredicate= criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        criteriaQuery.where(criteriaBuilder.and(finalPredicate));
        TypedQuery<T> query=entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        long count=8;
        Page<T> page=new PageImpl<>(query.getResultList(),pageable,count);
        System.out.println(page.getSize());
        return page;
    }

    protected List<Predicate> createPredicate(List<CustomPredicate> customPredicates, Root<T> root){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        List<Predicate> predicates=new ArrayList<>();
        System.out.println(tClass.getName());
        for (CustomPredicate customPredicate : customPredicates) {
            switch (customPredicate.getFunctionForSql()){
                case EQUAL:
                    predicates.add(criteriaBuilder.equal(root.get(customPredicate.getNameField()),customPredicate.getValue()));
                    break;
                case LIKE:
                    break;
            }
        }
        return predicates;
    }
}
