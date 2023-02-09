import config.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.entity.product.Category;
import project.vapeshop.entity.product.Item;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { JpaConfig.class })
@Transactional
public class ItemProductTest {
    @Autowired
    @Qualifier("itemProduct")
    Dao<Item,Integer> dao;

    @Test
    public void itemInsert() {
//        Item item=new Item("photo4", "Ursa Baby", new Category(), new BigDecimal(Double.toString(23.0)), 10);
//        dao.insertObject(item);
        Item item1=dao.selectObject(1);
//        System.out.println(item.equals(item1));
        System.out.println("test");
    }
}
