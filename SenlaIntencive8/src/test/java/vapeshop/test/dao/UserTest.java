package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.entity.user.Role;
import project.vapeshop.entity.user.User;
import vapeshop.test.config.H2Config;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@Transactional
@WebAppConfiguration
public class UserTest {

    @Autowired
    private AbstractDao<User,Integer> dao;

    @Test
    public void createUserTest(){
        dao.insertObject(new User("Petushok","Ilya","Aleksandrovich","log","pas","a331@mail",new Role(1)));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getName().equals("Ilya") : "проблемы с user create";
    }

    @Test
    public void selectUserTest(){
        assert dao.selectObject(1).getName().equals("Илья") : "проблемы с user select";
    }

    @Test
    public void deleteUserTest(){
        dao.insertObject(new User("Petushok","Ilya","Aleksandrovich","logi","pas1s","a323@mail",new Role(1)));
        List<User> userList= dao.selectObjects();
        int id= dao.selectObjects().get(userList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=userList.size():"проблемы с user delete";
    }

    @Test
    public void updateUserTest(){
        User user=dao.update(new User(1,"Petushok","Ilya Update","Aleksandrovich","login12","pass","a1233@mail",new Role(1)));
        assert dao.selectObject(user.getId()).getName().equals("Ilya Update") : "проблемы с user update";
    }
}
