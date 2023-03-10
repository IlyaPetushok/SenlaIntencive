package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Privileges;
import vapeshop.test.config.H2Config;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {H2Config.class})
@Transactional
@WebAppConfiguration
public class PrivilegeTest {

    @Autowired
    private Dao<Privileges,Integer> dao;

    @Test
    public void createPrivilegeTest(){
        Privileges privileges=dao.insertObject(new Privileges("test priv"));
        assert dao.selectObject(privileges.getId()).getName().equals("test priv") : "проблемы с privilege create";
    }

    @Test
    public void selectPrivilegeTest(){
        Privileges privileges=dao.insertObject(new Privileges("test priv"));
        assert dao.selectObject(privileges.getId()).getName().equals("test priv") : "проблемы с privilege select";
    }

    @Test
    public void deletePrivilegeTest(){
        dao.insertObject(new Privileges("delete user"));
        List<Privileges> privilegesList= dao.selectObjects();
        int id= dao.selectObjects().get(privilegesList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=privilegesList.size():"проблемы с privilege delete";
    }

    @Test
    public void updatePrivilegeTest(){
        dao.insertObject(new Privileges("priv"));
        List<Privileges> privilegesList= dao.selectObjects();
        int id= dao.selectObjects().get(privilegesList.size()-1).getId();
        dao.update(new Privileges(id,"priv update"));
        assert dao.selectObject(id).getName().equals("priv update") : "проблемы с privilege update";
    }
}
