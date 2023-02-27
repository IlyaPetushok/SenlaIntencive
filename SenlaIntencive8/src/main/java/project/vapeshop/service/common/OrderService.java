package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IOrderDao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.StatusOrder;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class OrderService {
    IOrderDao dao;
    ModelMapper modelMapper;

    @Autowired
    public OrderService(IOrderDao dao, ModelMapper modelMapper) {
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
    public OrderDTOForBasket addObject(OrderDTOFullInfo orderDTOFullInfo) {
        return modelMapper.map(dao.insertObject(modelMapper.map(orderDTOFullInfo,Order.class)),OrderDTOForBasket.class);
    }

    @Transactional
    public List<OrderDTOFullInfo> addObjects(List<OrderDTOFullInfo> orderDTOFullInfos) {
        List<Order> order=orderDTOFullInfos.stream()
                .map(orderDTOFullInfo -> modelMapper.map(orderDTOFullInfo,Order.class))
                .collect(Collectors.toList());
        return dao.insertObjects(order).stream()
                .map(order1 -> modelMapper.map(order1,OrderDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        Order order=modelMapper.map(orderDTOFullInfo,Order.class);
        order.setItems(orderDTOFullInfo.getItems());
        return modelMapper.map(dao.update(order),OrderDTOForBasket.class);
    }

    public List<OrderDTOForBasket> showObjectsFindByStatus(String status) {
        return dao.selectOrderFindByStatus(StatusOrder.valueOf(status)).stream()
                .map(order -> modelMapper.map(order, OrderDTOForBasket.class))
                .collect(Collectors.toList());
    }
}
