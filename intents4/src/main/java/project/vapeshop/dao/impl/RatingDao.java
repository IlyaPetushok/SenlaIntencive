package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityGetSetId;
import project.vapeshop.entity.common.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RatingDao extends AbstractDao<Rating> implements Dao<Rating> {
    private static List<Rating> ratings = new ArrayList<>();

    @Override
    public boolean insertObject(Rating rating) {
        ratings=insert(ratings,rating);
        return true;
    }

    @Override
    public boolean insertObjects(List<Rating> t) {
        for (Rating rating : t) {
            rating.setId(ratings.size());
            ratings.add(rating);
        }
        return true;
    }

    @Override
    public List<Rating> selectObjects() {
        return selects(ratings);
    }

    @Override
    public Rating selectObject(int id) {
        return select(ratings,id);
    }

    @Override
    public Rating update(Rating rating) {
        Rating rating1 = ratings.stream()
                .filter(r -> Objects.equals(r.getId(), rating.getId()))
                .findAny()
                .orElse(null);
        if (rating1 != null) {
            delete(rating1.getId());
            ratings.add(rating);
            return rating;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = ratings.stream()
                .filter(rating -> Objects.equals(rating.getId(), id))
                .map(rating -> rating.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            ratings.remove(i.intValue());
            return true;
        }
        return false;
    }
}
