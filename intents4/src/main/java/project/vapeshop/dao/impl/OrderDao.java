package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityGetSetId;
import project.vapeshop.entity.common.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderDao extends AbstractDao<Order> implements Dao<Order> {
    private static List<Order> orders = new ArrayList<>();

    @Override
    public boolean insertObject(Order order) {
        orders=insert(orders,order);
        return true;
    }

    @Override
    public boolean insertObjects(List<Order> order) {
        for (Order order1 : order) {
            order1.setId(orders.size());
            orders.add(order1);
        }
        return true;
    }

    @Override
    public List<Order> selectObjects() {
        return selects(orders);
    }

    @Override
    public Order selectObject(int id) {
        return select(orders,id);
    }

    @Override
    public Order update(Order order) {
        Order order1 = orders.stream()
                .filter(or -> or.getId() == order.getId())
                .findAny()
                .orElse(null);
        if (order1 != null) {
            delete(order1.getId());
            orders.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = orders.stream()
                .filter(order -> Objects.equals(order.getId(), id))
                .map(Order::getId).findFirst()
                .orElse(null);
        if (i != null) {
            orders.remove(i.intValue());
            return true;
        }
        return false;
    }
}
