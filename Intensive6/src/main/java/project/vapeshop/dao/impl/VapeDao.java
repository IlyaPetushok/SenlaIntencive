package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Item_;
import project.vapeshop.entity.product.Vape;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class VapeDao extends AbstractDao<Vape,Integer> {

    public static final String SELECT_VAPE_WHERE_VAPE_ID = "SELECT vape from Vape as vape where vape.id=?1";
    public static final String SELECT_VAPE = "select vape from Vape as vape";

    @Override
    public boolean insertObject(Vape vape) {
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
        Query query= entityManager.createQuery(SELECT_VAPE_WHERE_VAPE_ID);
        query.setParameter(1,id);
        return (Vape) query.getSingleResult();
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
}
