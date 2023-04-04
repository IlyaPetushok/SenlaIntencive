package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.product.Category;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;
import vapeshop.test.config.JpaConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class OrderTest {

    @Autowired
    private AbstractDao<Order,Integer> dao;

    @Autowired
    private AbstractDao<Item,Integer> daoItem;

    @Test
    public void createOrderTest(){
        List<Item> itemList=new ArrayList<>();
        itemList.add(daoItem.selectObject(1));
        dao.insertObject(new Order(new Date(2023, Calendar.FEBRUARY,26), new User(1),StatusOrder.Sent,150.0,itemList));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id)!=null : "проблемы с order create";
    }

    @Test
    public void selectOrderTest(){
        assert dao.selectObject(1) !=null : "проблемы с order select";
    }

    @Test
    public void deleteOrderTest(){
        List<Item> itemList=new ArrayList<>();
        itemList.add(daoItem.selectObject(1));
        dao.insertObject(new Order(new Date(2023, Calendar.FEBRUARY,26), new User(1),StatusOrder.Sent,150.0,itemList));
        List<Order> orderList= dao.selectObjects();
        int id= dao.selectObjects().get(orderList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=orderList.size():"проблемы с order delete";
    }

    @Test
    public void updateOrderTest(){
        List<Item> itemList=new ArrayList<>();
        itemList.add(daoItem.selectObject(1));
        dao.update(new Order(1,new Date(2023, Calendar.FEBRUARY,26), new User(1),StatusOrder.Accepted,150.0,itemList));
        assert dao.selectObject(1).getStatus().equals(StatusOrder.Accepted) : "проблемы с order update";
    }
}
