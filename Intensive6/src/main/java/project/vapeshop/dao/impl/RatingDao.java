package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.common.Rating;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RatingDao extends AbstractDao<Rating,Integer> {

    @Override
    public List<Rating> selectObjects() {
        Query query= entityManager.createQuery("select rat from Rating as rat");
        return query.getResultList();
    }

    @Override
    public Rating selectObject(Integer id) {
        Query query= entityManager.createQuery("select rat from Rating as rat where rat=?1");
        query.setParameter(1,id);
        return (Rating) query.getSingleResult();
    }

    @Override
    public Rating update(Rating rating) {
        Rating rating1=entityManager.find(Rating.class,rating.getId());
        rating1.setComment(rating.getComment());
        rating1.setItem(rating.getItem());
        rating1.setUser(rating.getUser());
        rating1.setQuantityStar(rating.getQuantityStar());
        return rating1;
    }
}
