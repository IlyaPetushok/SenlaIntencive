package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IVapeDao;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Vape;
import vapeshop.test.config.H2Config;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@Transactional
@WebAppConfiguration
public class VapeTest {

    @Autowired
    private IVapeDao dao;

    @Test
    public void createVapeTest(){
        dao.insertObject(new Vape(120,22450,"test",new Item(2)));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getType().equals("test") : "проблемы с vape create";
    }

    @Test
    public void selectVapeTest(){
        assert dao.selectObject(1).getType().equals("вейп") : "проблемы с vape select";
    }

    @Test
    public void deleteVapeTest(){
        dao.insertObject(new Vape(120,22450,"test",new Item(2)));
        List<Vape> vapeList= dao.selectObjects();
        int id= dao.selectObjects().get(vapeList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=vapeList.size():"проблемы с vape delete";
    }

    @Test
    public void updateVapeTest(){
        Vape vape=dao.update(new Vape(1,120,22450,"test update",new Item(2)));
        assert dao.selectObject(vape.getId()).getType().equals("test update") : "проблемы с vapeUpdate";
    }
}
