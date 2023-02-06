package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.common.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RatingDao extends AbstrarctDao<Rating,Integer>{
    private static final List<Rating> ratings = new ArrayList<>();


    public RatingDao() {
        super(ratings);
    }
}
