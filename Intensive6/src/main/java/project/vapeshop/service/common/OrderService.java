package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderService {
    Dao<Order,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public OrderService(Dao<Order,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public OrderDTOForBasket showObject(int id) {
        return modelMapper.map(dao.selectObject(id),OrderDTOForBasket.class);
    }

    public List<OrderDTOForBasket> showObjects() {
        return dao.selectObjects().stream()
                .map(order -> modelMapper.map(order,OrderDTOForBasket.class))
                .collect(Collectors.toList());
    }

    public boolean addObject(OrderDTOFullInfo orderDTOFullInfo) {
        return dao.insertObject(modelMapper.map(orderDTOFullInfo,Order.class));
    }

    public boolean addObjects(List<OrderDTOFullInfo> orderDTOFullInfos) {
        return dao.insertObjects(orderDTOFullInfos.stream()
                .map(orderDTOFullInfo -> modelMapper.map(orderDTOFullInfo,Order.class))
                .collect(Collectors.toList()));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(orderDTOFullInfo,Order.class)),OrderDTOForBasket.class);
    }
}
