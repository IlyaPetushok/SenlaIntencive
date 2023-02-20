package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Item_;
import project.vapeshop.entity.product.Vaporizer;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VaporizerDao extends AbstractDao<Vaporizer, Integer> {

    public static final String SELECT_VPOR = "select vpor from Vaporizer as vpor";
    public static final String SELECT_VPOR_FROM_VAPORIZER_AS_VPOR_WHERE_VPOR_ID_1 = "select vpor from Vaporizer  as vpor where vpor.id=?1";

    @Override
    public boolean insertObject(Vaporizer vaporizer) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery=criteriaBuilder.createQuery(Item.class);
        Root<Item> itemRoot=criteriaQuery.from(Item.class);
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),vaporizer.getItemForVaporizer().getId()));
        Query query= entityManager.createQuery(criteriaQuery);
        Item item= (Item) query.getSingleResult();
        vaporizer.setItemForVaporizer(item);
        return super.insertObject(vaporizer);
    }

    @Override
    public List<Vaporizer> selectObjects() {
        Query query=entityManager.createQuery(SELECT_VPOR);
        return query.getResultList();
    }

    @Override
    public Vaporizer selectObject(Integer id) {
        Query query=entityManager.createQuery(SELECT_VPOR_FROM_VAPORIZER_AS_VPOR_WHERE_VPOR_ID_1);
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
