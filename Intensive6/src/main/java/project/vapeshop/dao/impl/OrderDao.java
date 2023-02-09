package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.common.Order;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class OrderDao extends AbstractDao<Order,Integer> {
    @Override
    public List<Order> selectObjects() {
        Query query= entityManager.createQuery("Select ord from Order as ord");
        return query.getResultList();
    }

    @Override
    public Order selectObject(Integer id) {
        Query query= entityManager.createQuery("Select ord from Order as ord where ord.id=?1");
        query.setParameter(1,id);
        return (Order) query.getSingleResult();
    }

    @Override
    public Order update(Order order) {
        Order order1=entityManager.find(Order.class,order);
        order1.setDate(order.getDate());
        order1.setPrice(order.getPrice());
        order1.setStatus(order1.getStatus());
        order1.setUser(order.getUser());
        return order1;
    }
}
