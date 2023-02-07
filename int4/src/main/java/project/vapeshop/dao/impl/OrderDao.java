package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.common.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderDao extends AbstrarctDao<Order,Integer>{
    private static final List<Order> orders = new ArrayList<>();

    public OrderDao() {
        super(orders);
    }
}
