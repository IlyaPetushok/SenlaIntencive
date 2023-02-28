package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.entity.user.Role;
import vapeshop.test.config.JpaConfig;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class PrivilegeTest {

    @Autowired
    private AbstractDao<Privileges,Integer> dao;

    @Test
    public void createPrivilegeTest(){
        dao.insertObject(new Privileges("test priv"));
        int id=dao.selectObjects().get(dao.selectObjects().size()-1).getId();
        assert dao.selectObject(id).getName().equals("test priv") : "проблемы с privilege create";
    }

    @Test
    public void selectPrivilegeTest(){
        assert dao.selectObject(1).getName().equals("Просмотр") : "проблемы с privilege select";
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
