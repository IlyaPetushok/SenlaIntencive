package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.ILiquideDao;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Liquide;
import vapeshop.test.config.H2Config;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@Transactional
@WebAppConfiguration
public class LiquideTest {

    @Autowired
    private ILiquideDao dao;

    @Test
    public void createLiquideTest(){
        dao.insertObject(new Liquide(new Item(1),"test", 45, "солевой", 30));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getFlavour().equals("test") : "проблемы с vaporizer insert";
    }

    @Test
    public void selectLiquideTest(){
        assert dao.selectObject(1).getFlavour().equals("Кофе 3в1") : "проблемы с liquide select by id";
    }

    @Test
    public void deleteLiquideTest(){
        dao.insertObject(new Liquide(new Item(1),"test", 45, "солевой", 30));
        List<Liquide> vapeList= dao.selectObjects();
        int id= dao.selectObjects().get(vapeList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=vapeList.size():"проблемы с liquide delete";
    }

    @Test
    public void updateLiquideTest(){
        dao.update(new Liquide(1,new Item(1),"test update", 45, "солевой", 30));
        assert dao.selectObject(1).getFlavour().equals("test update") : "проблемы с liquide update";
    }
}
