package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IOrderDao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.dto.user.UserDTOForCommon;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.user.User;
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

    public OrderDTOFullInfo showObject(int id) {
        Order order=dao.selectObject(id);
        return modelMapper.map(order, OrderDTOFullInfo.class);
    }

    public List<OrderDTOForBasket> showObjects() {
        return dao.selectObjects().stream()
                .map(order -> modelMapper.map(order, OrderDTOForBasket.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTOForBasket addObject(OrderDTOFullInfo orderDTOFullInfo) {
        return modelMapper.map(dao.insertObject(modelMapper.map(orderDTOFullInfo, Order.class)), OrderDTOForBasket.class);
    }

    @Transactional
    public List<OrderDTOFullInfo> addObjects(List<OrderDTOFullInfo> orderDTOFullInfos) {
        List<Order> order = orderDTOFullInfos.stream()
                .map(orderDTOFullInfo -> modelMapper.map(orderDTOFullInfo, Order.class))
                .collect(Collectors.toList());
        return dao.insertObjects(order).stream()
                .map(o -> modelMapper.map(o, OrderDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(orderDTOFullInfo, Order.class)), OrderDTOForBasket.class);
    }

    public List<OrderDTOForBasket> showObjectsFindByStatus(String status) {
        return dao.selectOrderFindByStatus(StatusOrder.valueOf(status)).stream()
                .map(order -> modelMapper.map(order, OrderDTOForBasket.class))
                .collect(Collectors.toList());
    }

    public List<OrderDTOForBasket> showObjectsFindByUser(UserDTOForCommon userDTOForCommon){
        return dao.selectOrderFindByUser(modelMapper.map(userDTOForCommon, User.class)).stream()
                .map(order -> modelMapper.map(order,OrderDTOForBasket.class))
                .collect(Collectors.toList());
    }
}
