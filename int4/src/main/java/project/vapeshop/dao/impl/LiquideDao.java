package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Liquide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class LiquideDao extends AbstrarctDao<Liquide> {
    private static final List<Liquide> liquides = new ArrayList<>();


    public LiquideDao() {
        super(liquides);
    }
}
