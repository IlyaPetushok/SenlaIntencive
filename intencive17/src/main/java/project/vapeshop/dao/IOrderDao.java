package project.vapeshop.dao;

import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.StatusOrder;
import java.util.List;

public interface IOrderDao extends Dao<Order, Integer> {
//    по времени и цене
    List<Order> selectOrderFindByStatus(StatusOrder statusOrder);
}
