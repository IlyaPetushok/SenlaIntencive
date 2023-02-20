package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.product.Item;


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

    public OrderDTOForBasket addObject(OrderDTOFullInfo orderDTOFullInfo) {
//        OrderDTOFullInfo orderDTOFullInfo1=modelMapper.map(dao.insertObject(modelMapper.map(orderDTOFullInfo,Order.class)),OrderDTOFullInfo.class);
        return modelMapper.map(dao.insertObject(modelMapper.map(orderDTOFullInfo,Order.class)),OrderDTOForBasket.class);
    }

    public List<OrderDTOFullInfo> addObjects(List<OrderDTOFullInfo> orderDTOFullInfos) {
        List<Order> order=orderDTOFullInfos.stream()
                .map(orderDTOFullInfo -> modelMapper.map(orderDTOFullInfo,Order.class))
                .collect(Collectors.toList());
        for (int i = 0; i < order.size(); i++) {
            order.get(i).setItems(orderDTOFullInfos.get(i).getItems());
        }
        return dao.insertObjects(order).stream()
                .map(order1 -> modelMapper.map(order1,OrderDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        Order order=modelMapper.map(orderDTOFullInfo,Order.class);
        order.setItems(orderDTOFullInfo.getItems());
        return modelMapper.map(dao.update(order),OrderDTOForBasket.class);
    }
}