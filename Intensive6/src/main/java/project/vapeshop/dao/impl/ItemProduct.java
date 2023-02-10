package project.vapeshop.dao.impl;

import org.springframework.data.jpa.repository.Modifying;
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


    @Override
    public boolean insertObject(Item item) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> criteriaQuery=criteriaBuilder.createQuery(Category.class);
        Root<Category> categoryRoot= criteriaQuery.from(Category.class);
        criteriaQuery.where(criteriaBuilder.equal(categoryRoot.get(Category_.name),item.getCategory().getName()));
        Query query=entityManager.createQuery(criteriaQuery);
        item.setCategory((Category) query.getSingleResult());
        return super.insertObject(item);
    }

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
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),id));
        TypedQuery<Item> typedQuery= entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph",entityGraph);
        return itemGetWithProductCategory(typedQuery.getSingleResult());
    }

    @Transactional
    @Override
    public Item update(Item item) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaUpdate<Item> criteriaQuery= criteriaBuilder.createCriteriaUpdate(Item.class);
        Root<Item> itemRoot= criteriaQuery.from(Item.class);
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),item.getId()));
        criteriaQuery.set(Item_.name,item.getName());
        criteriaQuery.set(Item_.photo,item.getPhoto());
        criteriaQuery.set(Item_.quantity,item.getQuantity());
        criteriaQuery.set(Item_.price,item.getPrice());
        Query query= entityManager.createQuery(criteriaQuery);
        query.executeUpdate();
        return item;
    }
}
