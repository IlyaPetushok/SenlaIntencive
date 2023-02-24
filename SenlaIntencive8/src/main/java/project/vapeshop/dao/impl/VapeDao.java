package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IVapeDao;
import project.vapeshop.entity.product.*;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VapeDao extends AbstractDao<Vape,Integer> implements IVapeDao {

    public static final String SELECT_VAPE = "select vape from Vape as vape";

    @Override
    public Vape insertObject(Vape vape) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery=criteriaBuilder.createQuery(Item.class);
        Root<Item> itemRoot=criteriaQuery.from(Item.class);
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),vape.getItemForVape().getId()));
        Query query= entityManager.createQuery(criteriaQuery);
        Item item= (Item) query.getSingleResult();
        vape.setItemForVape(item);
        return super.insertObject(vape);
    }

    @Override
    public List<Vape> selectObjects() {
        Query query=entityManager.createQuery(SELECT_VAPE);
        return query.getResultList();
    }

    @Override
    public Vape selectObject(Integer id) {
        EntityGraph<?> entityGraph= entityManager.getEntityGraph("entity-graph-item");
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Vape> criteriaQuery= criteriaBuilder.createQuery(Vape.class);
        Root<Vape> vapeRoot= criteriaQuery.from(Vape.class);
        criteriaQuery.select(vapeRoot)
                .where(criteriaBuilder.equal(vapeRoot.get(Vape_.id),id));
        TypedQuery<Vape> query= entityManager.createQuery(criteriaQuery);
        query.setHint("javax.persistence.loadgraph",entityGraph);
        return query.getSingleResult();
    }

    @Override
    public Vape update(Vape vape) {
        Vape vape1=entityManager.find(Vape.class,vape.getId());
        vape1.setItemForVape(vape.getItemForVape());
        vape1.setBattery(vape.getBattery());
        vape1.setType(vape.getType());
        vape1.setPower(vape.getPower());
        return vape1;
    }

    @Override
    public List<Vape> findByTypeVape(String typeVape) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Vape> criteriaQuery= criteriaBuilder.createQuery(Vape.class);
        Root<Vape> vapeRoot= criteriaQuery.from(Vape.class);
        criteriaQuery.where(criteriaBuilder.equal(vapeRoot.get(Vape_.type),typeVape));
        TypedQuery<Vape> query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
