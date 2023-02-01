package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.mapper.impl.common.OrderForBasketMapper;
import project.vapeshop.mapper.impl.common.OrderFullInfoMapper;

import java.util.List;

@Component
public class OrderService {
    Dao<Order> dao;
    OrderForBasketMapper orderForBasketMapper;
    OrderFullInfoMapper orderFullInfoMapper;

    @Autowired
    public OrderService(Dao<Order> dao, OrderForBasketMapper orderForBasketMapper, OrderFullInfoMapper orderFullInfoMapper) {
        this.dao = dao;
        this.orderForBasketMapper = orderForBasketMapper;
        this.orderFullInfoMapper = orderFullInfoMapper;
    }

    public OrderDTOForBasket showObject(int id) {
        return orderForBasketMapper.toDTO(dao.selectObject(id));
    }

    public List<OrderDTOForBasket> showObjects() {
        return orderForBasketMapper.toDTOs(dao.selectObjects());
    }

    public boolean addObject(OrderDTOFullInfo orderDTOFullInfo) {
        return dao.insertObject(orderFullInfoMapper.toEntity(orderDTOFullInfo));
    }

    public boolean addObjects(List<OrderDTOFullInfo> orderDTOFullInfos) {
        return dao.insertObjects(orderFullInfoMapper.toEntities(orderDTOFullInfos));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        return orderForBasketMapper.toDTO(dao.update(orderFullInfoMapper.toEntity(orderDTOFullInfo)));
    }
}
