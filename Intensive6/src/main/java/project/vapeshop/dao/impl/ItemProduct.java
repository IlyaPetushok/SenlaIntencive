package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.entity.product.*;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;


@Repository
public class ItemProduct extends AbstractDao<Item,Integer>{
    private static final String LIQUIDE ="Жидкости";
    private static final String VAPORIZER ="Испарители,Картриджы,Койлы";
    private static final String VAPE ="Вейпы и подики";
    @Transactional
    @Override
    public List<Item> selectObjects() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<Item> itemRoot= criteriaQuery.from(Item.class);
        criteriaQuery.select(itemRoot);
        Query query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Item itemGetWithProductCategory(Item item){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery= criteriaBuilder.createQuery(Item.class);
        Root<Item> itemRoot=criteriaQuery.from(Item.class);
        switch (item.getCategory().getName()){
            case LIQUIDE:
                itemRoot.join(Item_.liquide,JoinType.INNER);
                break;
            case VAPORIZER:
                itemRoot.join(Item_.vaporizer,JoinType.INNER);
                break;
            case VAPE:
                itemRoot.join(Item_.vape,JoinType.INNER);
                break;
        }
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),item.getId()));
        TypedQuery<Item> typedQuery=entityManager.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    @Transactional
    @Override
    public Item selectObject(Integer id) {
        EntityGraph<?> entityGraph=entityManager.getEntityGraph("entity-item-graph-category");
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery= criteriaBuilder.createQuery(Item.class);
        Root<Item> itemRoot= criteriaQuery.from(Item.class);
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),2));
        TypedQuery<Item> typedQuery= entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph",entityGraph);
        Item item1=typedQuery.getSingleResult();
        return itemGetWithProductCategory(typedQuery.getSingleResult());
    }

    @Transactional
    @Override
    public Item update(Item item) {
        Item item1=selectObject(item.getId());
        item1.setQuantity(item.getQuantity());
        item1.setPrice(item.getPrice());
        item1.setName(item.getName());
        item1.setPhoto(item.getPhoto());
        return item1;
    }
}
