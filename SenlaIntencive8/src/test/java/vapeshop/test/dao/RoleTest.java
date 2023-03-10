package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Role;
import vapeshop.test.config.H2Config;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@Transactional
@WebAppConfiguration
public class RoleTest {

    @Autowired
    private Dao<Role,Integer> dao;

    @Test
    public void createRoleTest(){
        dao.insertObject(new Role("testuser"));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getName().equals("testuser") : "проблемы с category";
    }

    @Test
    public void selectRoleTest(){
        assert dao.selectObject(1).getName().equals("ROLE_USER") : "проблемы с category";
    }

    @Test
    public void deleteCategoryTest(){
        dao.insertObject(new Role("admintest"));
        List<Role> roleList= dao.selectObjects();
        int id= dao.selectObjects().get(roleList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=roleList.size():"проблемы с category";
    }

    @Test
    public void updateCategoryTest(){
        dao.insertObject(new Role("admin"));
        List<Role> roleList= dao.selectObjects();
        int id= dao.selectObjects().get(roleList.size()-1).getId();
        dao.update(new Role(id,"admin update"));
        assert dao.selectObject(id).getName().equals("admin update") : "проблемы с category";
    }
}
