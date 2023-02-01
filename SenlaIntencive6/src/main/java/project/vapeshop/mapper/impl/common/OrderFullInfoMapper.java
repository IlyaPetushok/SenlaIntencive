package project.vapeshop.mapper.impl.common;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class OrderFullInfoMapper implements Mapper<Order, OrderDTOFullInfo> {
    @Override
    public OrderDTOFullInfo toDTO(Order order) {
        return null;
    }

    @Override
    public List<OrderDTOFullInfo> toDTOs(List<Order> orderEntities) {
        return null;
    }

    @Override
    public Order toEntity(OrderDTOFullInfo orderDTOFullInfo) {
        return new Order(orderDTOFullInfo.getId(),orderDTOFullInfo.getDate(),orderDTOFullInfo.getIdUser(),orderDTOFullInfo.getStatus(),orderDTOFullInfo.getPrice());
    }

    @Override
    public List<Order> toEntities(List<OrderDTOFullInfo> orderDTOFullInfos) {
        return orderDTOFullInfos.stream()
                .map(orderDTOFullInfo -> new Order(orderDTOFullInfo.getId(),orderDTOFullInfo.getDate(),orderDTOFullInfo.getIdUser(),orderDTOFullInfo.getStatus(),orderDTOFullInfo.getPrice()))
                .toList();
    }
}
