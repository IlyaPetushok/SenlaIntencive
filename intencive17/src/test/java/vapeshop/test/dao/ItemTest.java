package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IItemDao;
import project.vapeshop.dao.IVapeDao;
import project.vapeshop.entity.product.Category;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Vape;
import vapeshop.test.config.H2Config;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@Transactional
@WebAppConfiguration
public class ItemTest {
    @Autowired
    IItemDao dao;

    @Autowired
    IVapeDao daoVape;

    @Test
    public void createItemTest(){
        Item item = new Item("photoest", "test product", new Category("Испарители,Картриджы,Койлы"), new BigDecimal(Double.toString(23.0)), 10);
        dao.insertObject(item);
        List<Item> items=dao.selectObjects();
        assert items.get(items.size()-1).getName().equals("test product") : "dont work create item";
    }

    @Test
    public void selectItemTest(){
        assert dao.selectObject(1).getName().equals("Мишки 3в1") : "проблемы с item";
    }

    @Test
    public void deleteItemTest(){
        Item item=new Item("photo4", "HotSpot BubleGum", new Category("Вейпы и подики"), new BigDecimal(Double.toString(23.0)), 15);
        dao.insertObject(item);
        List<Item> itemList= dao.selectObjects();
        daoVape.insertObject(new Vape(120,22450,"test",new Item(itemList.get(itemList.size()-1).getId())));
        dao.delete(itemList.get(itemList.size()-1).getId());
        assert dao.selectObjects().size()!=itemList.size():"проблемы с item";
    }

    @Test
    public void updateItemTest(){
        Item item=new Item("photo4", "HotSpot BubleGum", new Category("Вейпы и подики"), new BigDecimal(Double.toString(23.0)), 15);
        dao.insertObject(item);
        List<Item> itemList= dao.selectObjects();
        int id = itemList.get(itemList.size()-1).getId();
        daoVape.insertObject(new Vape(120,22450,"test",new Item(itemList.get(itemList.size()-1).getId())));
        dao.update(new Item(id,"photo4", "HotSpot BubleGum", new Category("Вейпы и подики"), new BigDecimal(Double.toString(23.0)), 15));
        assert dao.selectObject(id).getName().equals("HotSpot BubleGum") : "проблемы с item";
    }
}
