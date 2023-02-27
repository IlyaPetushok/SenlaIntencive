package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.IVaporizerDao;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Item_;
import project.vapeshop.entity.product.Vaporizer;
import project.vapeshop.entity.product.Vaporizer_;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VaporizerDao extends AbstractDao<Vaporizer, Integer> implements IVaporizerDao {


    @Override
    public Vaporizer insertObject(Vaporizer vaporizer) {
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
        EntityGraph<?> entityGraph= entityManager.getEntityGraph("entity-graph-item-vaporizer");
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Vaporizer> criteriaQuery= criteriaBuilder.createQuery(Vaporizer.class);
        TypedQuery<Vaporizer> typedQuery=entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph",entityGraph);
        return typedQuery.getResultList();
    }

    @Override
    public Vaporizer selectObject(Integer id) {
        EntityGraph<?> entityGraph= entityManager.getEntityGraph("entity-graph-item-vaporizer");
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Vaporizer> criteriaQuery= criteriaBuilder.createQuery(Vaporizer.class);
        Root<Vaporizer> vaporizerRoot= criteriaQuery.from(Vaporizer.class);
        criteriaQuery.where(criteriaBuilder.equal(vaporizerRoot.get(Vaporizer_.id),id));
        TypedQuery<Vaporizer> typedQuery=entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph",entityGraph);
        return typedQuery.getSingleResult();
    }

    @Override
    public Vaporizer update(Vaporizer vaporizer) {
        Vaporizer vaporizer1=entityManager.find(Vaporizer.class,vaporizer.getId());
        vaporizer1.setResistance(vaporizer.getResistance());
        vaporizer1.setType(vaporizer.getType());
        vaporizer1.setItemForVaporizer(entityManager.find(Item.class,vaporizer.getItemForVaporizer().getId()));
        return vaporizer1;
    }

    @Override
    public List<Vaporizer> findByTypeVaporizer(String typeVape) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Vaporizer> criteriaQuery= criteriaBuilder.createQuery(Vaporizer.class);
        Root<Vaporizer> vaporizerRoot= criteriaQuery.from(Vaporizer.class);
        criteriaQuery.where(criteriaBuilder.equal(vaporizerRoot.get(Vaporizer_.type),typeVape));
        TypedQuery<Vaporizer> typedQuery=entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
