package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Order_;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.entity.common.Rating_;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RatingDao extends AbstractDao<Rating,Integer> {

    @Override
    public boolean insertObject(Rating rating) {

        return super.insertObject(rating);
    }

    @Override
    public List<Rating> selectObjects() {
        Query query= entityManager.createQuery("select rat from Rating as rat");
        return query.getResultList();
    }

    @Override
    public Rating selectObject(Integer id) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Rating> criteriaQuery= criteriaBuilder.createQuery(Rating.class);
        Root<Rating> ratingRoot=criteriaQuery.from(Rating.class);
        criteriaQuery.where(criteriaBuilder.equal(ratingRoot.get(Rating_.id),id));
        TypedQuery<Rating> query=entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
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

    @Override
    public boolean delete(Integer id) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaDelete<Rating> criteriaDelete=criteriaBuilder.createCriteriaDelete(Rating.class);
        Root<Rating> ratingRoot=criteriaDelete.from(Rating.class);
        criteriaDelete.where(criteriaBuilder.equal(ratingRoot.get(Rating_.id),id));
        Query query=entityManager.createQuery(criteriaDelete);
        query.executeUpdate();
        return true;
    }
}
