package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Vape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VapeDao extends AbstrarctDao<Vape,Integer> {
    private static final List<Vape> vapes = new ArrayList<>();


    public VapeDao() {
        super(vapes);
    }
}
