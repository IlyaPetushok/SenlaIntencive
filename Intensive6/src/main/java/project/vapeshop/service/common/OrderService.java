package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.product.Item;


import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class OrderService {
    AbstractDao<Order,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public OrderService(AbstractDao<Order,Integer> dao, ModelMapper modelMapper) {
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

    @Transactional
    public boolean addObject(OrderDTOFullInfo orderDTOFullInfo) {
        Order order=modelMapper.map(orderDTOFullInfo,Order.class);
        return dao.insertObject(order);
    }

    @Transactional
    public boolean addObjects(List<OrderDTOFullInfo> orderDTOFullInfos) {
        List<Order> order=orderDTOFullInfos.stream()
                .map(orderDTOFullInfo -> modelMapper.map(orderDTOFullInfo,Order.class))
                .collect(Collectors.toList());
        for (int i = 0; i < order.size(); i++) {
            order.get(i).setItems(orderDTOFullInfos.get(i).getItemList());
            System.out.println(order.get(i).getStatus());
        }
        return dao.insertObjects(order);
    }

    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        Order order=modelMapper.map(orderDTOFullInfo,Order.class);
        order.setItems(orderDTOFullInfo.getItemList());
        return modelMapper.map(dao.update(order),OrderDTOForBasket.class);
    }
}
