package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.user.User;

import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrderDao extends AbstractDao<Order, Integer> {

    @Override
    public Order insertObject(Order order) {
        User user = entityManager.find(User.class, order.getUser().getId());
        order.setUser(user);
        return entityManager.merge(order);
    }

    @Override
    public List<Order> selectObjects() {
        EntityGraph<?> entityGraph = entityManager.getEntityGraph("order_items");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
        Root<Order> orderRoot = criteriaQuery.from(Order.class);
        TypedQuery<Order> query = entityManager.createQuery(criteriaQuery);
        query.setHint("javax.persistence.loadgraph",entityGraph);
        return query.getResultList();
    }

    @Override
    public Order selectObject(Integer id) {
        return entityManager.find(Order.class,id);
    }

    @Override
    public Order update(Order order) {
        Order order1 = entityManager.find(Order.class, order.getId());
        order1.setDate(order.getDate());
        order1.setPrice(order.getPrice());
        order1.setStatus(order.getStatus());
        order1.setUser(order.getUser());
        order1.setItems(order.getItems());
        return order1;
    }
}
