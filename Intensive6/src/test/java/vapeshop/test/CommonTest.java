package vapeshop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.product.*;
import project.vapeshop.entity.user.Role;
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
public class CommonTest {
    @Autowired
    @Qualifier("orderDao")
    AbstractDao<Order,Integer> orderDao;

    @Autowired
    @Qualifier("ratingDao")
    AbstractDao<Rating,Integer> ratingDao;

    @Autowired
    @Qualifier("itemProduct")
    AbstractDao<Item, Integer> dao;

    @Autowired
    @Qualifier("categoryDao")
    AbstractDao<Category, Integer> categoryIntegerDao;

    @Autowired
    @Qualifier("userDao")
    AbstractDao<User,Integer> daoUser;

    @Test
    public void commonTest(){

        daoUser.insertObject(new User("Petushok","Ilya","Aleksandrovich","login","pass","a33@mail",new Role(1)));
        User user=daoUser.selectObject(1);
        assert user.getSurname().equals("Petushok") : "dont work insert user";


        Category category = new Category("тест категори");
        categoryIntegerDao.insertObject(category);
        Category category1 = categoryIntegerDao.selectObject(1);
        assert category1.getName().equals("тест категори") : "проблемы с category";


        List<Item> itemList=new ArrayList<>();
        itemList.add(new Item("photoest", "test product", category1, new BigDecimal(Double.toString(23.0)), 10));
        itemList.add(new Item("photoest", "test product", category1, new BigDecimal(Double.toString(23.0)), 10));
        itemList.add(new Item("photoest", "test product", category1, new BigDecimal(Double.toString(23.0)), 10));
        dao.insertObjects(itemList);

        Order order=new Order(new Date(2023, Calendar.FEBRUARY,26),new User(1), StatusOrder.Accepted,150.0,itemList);
        orderDao.insertObject(order);
        Order order1=orderDao.selectObject(1);
        assert order1.getStatus().equals(StatusOrder.Accepted):"order dont work insert";


        Rating rating= new Rating("good", 5, new Item(1), new User(1));
        ratingDao.insertObject(rating);
    }
}
