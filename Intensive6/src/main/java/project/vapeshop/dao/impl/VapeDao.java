package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Vape;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VapeDao extends AbstractDao<Vape,Integer> {
    @Override
    public List<Vape> selectObjects() {
        Query query=entityManager.createQuery("select vape from Vape as vape");
        return query.getResultList();
    }

    @Override
    public Vape selectObject(Integer id) {
        Query query= entityManager.createQuery("SELECT vape from Vape as vape where vape.id=?1");
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
