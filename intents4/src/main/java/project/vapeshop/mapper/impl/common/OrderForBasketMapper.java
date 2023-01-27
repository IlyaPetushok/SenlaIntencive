package project.vapeshop.mapper.impl.common;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.entity.common.Order;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class OrderForBasketMapper implements Mapper<Order, OrderDTOForBasket> {
    @Override
    public OrderDTOForBasket toDTO(Order order) {
        return new OrderDTOForBasket(order.getId(), order.getDate(), order.getStatus(), order.getPrice());
    }

    @Override
    public List<OrderDTOForBasket> toDTOs(List<Order> orderEntities) {
        return orderEntities.stream()
                .map(order -> new OrderDTOForBasket(order.getId(), order.getDate(), order.getStatus(), order.getPrice()))
                .toList();
    }

    @Override
    public Order toEntity(OrderDTOForBasket orderDTOForBasket) {
        return null;
    }

    @Override
    public List<Order> toEntities(List<OrderDTOForBasket> orderDTOForBaskets) {
        return null;
    }
}
