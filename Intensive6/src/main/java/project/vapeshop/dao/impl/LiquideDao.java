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
        CriteriaQuery<Item> criteriaQuery=criteriaBuilder.createQuery(Item.class);
        Root<Item> itemRoot=criteriaQuery.from(Item.class);
        criteriaQuery.where(criteriaBuilder.equal(itemRoot.get(Item_.id),liquide.getItemForLiquide().getId()));
        Query query= entityManager.createQuery(criteriaQuery);
        Item item= (Item) query.getSingleResult();
        liquide.setItemForLiquide(item);
        return super.insertObject(liquide);
    }

    @Override
    public List<Liquide> selectObjects() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery=criteriaBuilder.createQuery();
        Root<Liquide> liquideRoot= criteriaQuery.from(Liquide.class);
        criteriaQuery.select(liquideRoot);
        Query query= entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

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
        System.out.println(liquide);
        return liquide;
    }

    @Override
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
