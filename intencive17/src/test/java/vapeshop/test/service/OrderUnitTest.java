package vapeshop.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;
import project.vapeshop.service.common.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class OrderUnitTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private OrderService orderService;
    @Mock
    private Dao<Order,Integer> orderDao;
    @Spy
    private ModelMapper modelMapper;

    private static final List<Item> items=new ArrayList<>();
    private static final Order order=new Order(1,new Date(),new User(), StatusOrder.Sent,15.5,items);
    private static final OrderDTOFullInfo orderDto=new OrderDTOFullInfo(2,new Date(),StatusOrder.Sent,15.5,new User(),items);


    @Test
    public void testGetByIdOrder(){
        when(orderDao.selectObject(1)).thenReturn(order);
        Assertions.assertEquals(orderService.showObject(1).getId(),order.getId());
        verify(orderDao,times(1)).selectObject(any());
    }

    @Test
    public void testGetAllOrders(){
        List<Order> list=new ArrayList<>();
        list.add(new Order(1,new Date(),new User(),StatusOrder.Sent,15.5,items));
        list.add(new Order(2,new Date(),new User(),StatusOrder.Sent,15.5,items));
        list.add(new Order(3,new Date(),new User(),StatusOrder.Sent,15.5,items));

        when(orderDao.selectObjects()).thenReturn(list);
        List<OrderDTOForBasket> orders=orderService.showObjects();
        for (int i = 0; i < orders.size(); i++) {
            Assertions.assertEquals(orders.get(i).getId(),list.get(i).getId());
        }
        verify(orderDao,times(1)).selectObjects();
    }

    @Test
    public void testUpdateOrder(){
        when(orderDao.update(any(Order.class))).thenReturn(order);
        Assertions.assertEquals(orderService.updateObject(orderDto).getId(),order.getId());
        verify(orderDao,times(1)).update(any());
    }

    @Test
    public void testDeleteOrder(){
        when(orderDao.delete(1)).thenReturn(true);
        Assertions.assertTrue(orderService.deleteObject(1));
        verify(orderDao,times(1)).delete(1);
    }
}
