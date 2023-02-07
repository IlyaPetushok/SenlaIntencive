package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Vaporizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VaporizerDao extends AbstrarctDao<Vaporizer,Integer> {
    private static final List<Vaporizer> vaporizers = new ArrayList<>();

    public VaporizerDao() {
        super(vaporizers);
    }



}
