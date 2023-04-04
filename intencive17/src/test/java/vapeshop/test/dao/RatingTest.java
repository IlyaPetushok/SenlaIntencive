package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;
import vapeshop.test.config.JpaConfig;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class RatingTest {

    @Autowired
    private AbstractDao<Rating,Integer> dao;

    @Test
    public void createRatingTest(){
        dao.insertObject( new Rating("good", 5, new Item(1), new User(1)));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getComment().equals("good") : "проблемы с category";
    }

    @Test
    public void selectRatingTest(){
        assert dao.selectObject(1).getComment().equals("Очень вкусная жижа") : "проблемы с category";
    }

    @Test
    public void deleteRatingTest(){
        dao.insertObject( new Rating("good", 5, new Item(1), new User(1)));
        List<Rating> ratingList= dao.selectObjects();
        int id= dao.selectObjects().get(ratingList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=ratingList.size():"проблемы с category";
    }

    @Test
    public void updateRatingTest(){
        dao.insertObject( new Rating("good", 5, new Item(1), new User(1)));
        List<Rating> ratingList= dao.selectObjects();
        int id= dao.selectObjects().get(ratingList.size()-1).getId();
        dao.update(new Rating(id,"goodUpdate", 5, new Item(1), new User(1)));
        assert dao.selectObject(id).getComment().equals("goodUpdate") : "проблемы с category";
    }
}
