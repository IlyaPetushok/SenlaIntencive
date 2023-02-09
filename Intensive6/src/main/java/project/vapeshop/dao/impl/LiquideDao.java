package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.entity.product.*;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class LiquideDao extends AbstractDao<Liquide,Integer> {
    @Override
    public boolean insertObject(Liquide liquide) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<Item> itemRoot=criteriaQuery.from(Item.class);
        Root<Liquide> liquideRoot= criteriaQuery.from(Liquide.class);
//        Join<Liquide,Item> liquideItemJoin=liquideRoot.join(Liquide_.itemForLiquide);
//        System.out.println(l);
        criteriaQuery.select(itemRoot)
                .where(criteriaBuilder.equal(itemRoot.get(Item_.liquide),liquideRoot.get(Liquide_.id)));
        Query query= entityManager.createQuery(criteriaQuery);
        Item item= (Item) query.getSingleResult();
//        liquide.setItemForLiquide(item.getId());
        liquide.setItemForLiquide(item);
        return super.insertObject(liquide);
    }

    @Transactional
    @Override
    public List<Liquide> selectObjects() {
//        CriteriaBuilder
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<Liquide> liquideRoot= criteriaQuery.from(Liquide.class);
        criteriaQuery.select(liquideRoot);
        Query query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Transactional
    public List<Item> selectObjectTypeNicotine(){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery= criteriaBuilder.createQuery();
        Root<Liquide> liquideRoot= criteriaQuery.from(Liquide.class);
        criteriaQuery.select(liquideRoot)
                .where(liquideRoot.get(Liquide_.typeNicotine)
                        .in("солевой","обычный"));
        Query query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Transactional
    @Override
    public  Liquide selectObject(Integer id) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery= criteriaBuilder.createQuery();
        Root<Liquide> liquideRoot= criteriaQuery.from(Liquide.class);
        criteriaQuery.select(liquideRoot)
                .where(criteriaBuilder.equal(liquideRoot.get(Liquide_.id),id));
        Query query= entityManager.createQuery(criteriaQuery);
        return (Liquide) query.getSingleResult();
    }

    @Transactional
    @Override
    public Liquide update(Liquide liquide) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaUpdate<Liquide> criteriaUpdate=criteriaBuilder.createCriteriaUpdate(Liquide.class);
        Root<Liquide> liquideRoot=criteriaUpdate.from(Liquide.class);
        criteriaUpdate.where(criteriaBuilder.equal(liquideRoot.get(Liquide_.id),liquide.getId()));
        criteriaUpdate.set(Liquide_.typeNicotine, liquide.getTypeNicotine());
        criteriaUpdate.set(Liquide_.fortress,liquide.getFortress());
        criteriaUpdate.set(Liquide_.flavour, liquide.getFlavour());
        criteriaUpdate.set(Liquide_.volume,liquide.getVolume());
        Query query=entityManager.createQuery(criteriaUpdate);
        query.executeUpdate();
        return liquide;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaDelete<Liquide> criteriaDelete =criteriaBuilder.createCriteriaDelete(Liquide.class);
        Root<Liquide> liquideRoot=criteriaDelete.from(Liquide.class);
        criteriaDelete.where(criteriaBuilder.equal(liquideRoot.get(Liquide_.id),id));
        Query query=entityManager.createQuery(criteriaDelete);
        query.executeUpdate();
        return true;
    }
}
