package vapeshop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.ItemProduct;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.*;
import vapeshop.test.config.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class ProductTest {
    @Autowired
    @Qualifier("itemProduct")
    Dao<Item, Integer> dao;

    @Autowired
    @Qualifier("liquideDao")
    Dao<Liquide, Integer> daoLiquide;

    @Autowired
    @Qualifier("vapeDao")
    Dao<Vape, Integer> daoVape;

    @Autowired
    @Qualifier("vaporizerDao")
    Dao<Vaporizer, Integer> daoVaporizer;

    @Autowired
    @Qualifier("categoryDao")
    Dao<Category, Integer> categoryIntegerDao;

    @Test
    public void productInsert() {
        Category category = new Category("тест категори");
        categoryIntegerDao.insertObject(category);
        Category category1 = categoryIntegerDao.selectObject(1);
        assert category1.getName().equals("тест категори") : "проблемы с category";

        Item item = new Item("photoest", "test product", category1, new BigDecimal(Double.toString(23.0)), 10);
        dao.insertObject(item);
        List<Item> itemList = dao.selectObjects();
        assert itemList.size() == 1 : "item dont work selects";
        Item item1 = dao.selectObject(1);
        assert item1.getName().equals("test product") : "dont work select item";

        Liquide liquide = new Liquide(item1, "test flavour", 45, "солевой", 30);
        daoLiquide.insertObject(liquide);
        Liquide liquide1 = daoLiquide.selectObject(1);
        assert liquide1.getFlavour().equals("test flavour") : "liquide dont work insert";

        dao.insertObject(new Item("photoest", "test product", category1, new BigDecimal(Double.toString(23.0)), 10));
        Vape vape = new Vape(120, 22450, "test mode", new Item(2));
        daoVape.insertObject(vape);
        Vape vape1 = daoVape.selectObject(1);
        assert vape1.getType().equals("test mode") : "vape dont work vape";


        dao.insertObject(new Item("photoest", "test product", category1, new BigDecimal(Double.toString(23.0)), 10));
        daoVaporizer.insertObject(new Vaporizer(0.6, "испаритель",new Item(3)));
        Vaporizer vaporizer = daoVaporizer.selectObject(1);
        assert vaporizer.getType().equals("испаритель") : "insert dont wotk vaporizer";
    }
}
