package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IOrderDao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.dto.user.UserDTOForCommon;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.user.User;
import project.vapeshop.exception.NotFoundException;

import javax.persistence.NoResultException;
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
        Order order;
        try {
            order = dao.selectObject(id);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "operation is fail because order dont found");
        }
        return modelMapper.map(order, OrderDTOFullInfo.class);
    }

    public List<OrderDTOForBasket> showObjects() {
        List<Order> orders = dao.selectObjects();
        if (orders.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "order list is empty");
        }
        return orders.stream()
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
        try {
            return dao.delete(id);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "operation is fail because order dont found");
        }
    }

    @Transactional
    public OrderDTOForBasket updateObject(OrderDTOFullInfo orderDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(orderDTOFullInfo, Order.class)), OrderDTOForBasket.class);
    }

    public List<OrderDTOForBasket> showObjectsFindByStatus(String status) {
        try {
            return dao.selectOrderFindByStatus(StatusOrder.valueOf(status)).stream()
                    .map(order -> modelMapper.map(order, OrderDTOForBasket.class))
                    .collect(Collectors.toList());
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "order dont found");
        }
    }

    public List<OrderDTOForBasket> showObjectsFindByUser(UserDTOForCommon userDTOForCommon) {
        try {
            return dao.selectOrderFindByUser(modelMapper.map(userDTOForCommon, User.class)).stream()
                    .map(order -> modelMapper.map(order, OrderDTOForBasket.class))
                    .collect(Collectors.toList());
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "order dont found");
        }
    }
}
