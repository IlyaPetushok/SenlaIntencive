package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Vaporizer;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VaporizerDao extends AbstractDao<Vaporizer, Integer> {
    @Override
    public List<Vaporizer> selectObjects() {
        Query query=entityManager.createQuery("select vpor from Vaporizer as vpor");
        return query.getResultList();
    }

    @Override
    public Vaporizer selectObject(Integer id) {
        Query query=entityManager.createQuery("select vpor from Vaporizer  as vpor where vpor.id=?1");
        query.setParameter(1,id);
        return (Vaporizer) query.getSingleResult();
    }

    @Override
    public Vaporizer update(Vaporizer vaporizer) {
        Vaporizer vaporizer1=entityManager.find(Vaporizer.class,vaporizer.getId());
        vaporizer1.setResistance(vaporizer.getResistance());
        vaporizer1.setType(vaporizer.getType());
        return vaporizer1;
    }
}
