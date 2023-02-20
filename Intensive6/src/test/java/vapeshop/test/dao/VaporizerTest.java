package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.Category;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Vape;
import project.vapeshop.entity.product.Vaporizer;
import vapeshop.test.config.JpaConfig;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class VaporizerTest {
    @Autowired
    private AbstractDao<Vaporizer,Integer> dao;

    @Autowired
    private AbstractDao<Item,Integer> daoItem;


    @Test
    public void createVaporizerTest(){
        Item item = new Item("photoest", "test product", new Category("Испарители,Картриджы,Койлы"), new BigDecimal(Double.toString(23.0)), 10);
        daoItem.insertObject(item);
        List<Item> items=daoItem.selectObjects();
        dao.insertObject(new Vaporizer(9.9,"испаритель",new Item(items.get(items.size()-1).getId())));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getResistance()==9.9 : "проблемы с vaporizer insert";
    }

    @Test
    public void selectVaporizerTest(){
        assert dao.selectObject(1).getType().equals("испаритель") : "проблемы с vaporizer select by id";
    }

    @Test
    public void deleteVaporizerTest(){
        Item item = new Item("photoest", "test product", new Category("Испарители,Картриджы,Койлы"), new BigDecimal(Double.toString(23.0)), 10);
        daoItem.insertObject(item);
        List<Item> items=daoItem.selectObjects();
        dao.insertObject(new Vaporizer(0.6,"испаритель",new Item(items.get(items.size()-1).getId())));
        List<Vaporizer> vaporizerList= dao.selectObjects();
        int id= dao.selectObjects().get(vaporizerList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=vaporizerList.size():"проблемы с vaporier delete";
    }

    @Test
    public void updateVaporizerTest(){
        dao.update(new Vaporizer(1,1.8,"испаритель",new Item(4)));
        assert dao.selectObject(1).getResistance()==1.8 : "проблемы с vaporizer update";
    }
}
