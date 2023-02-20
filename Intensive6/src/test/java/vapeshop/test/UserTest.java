package vapeshop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.entity.user.Role;
import project.vapeshop.entity.user.User;
import vapeshop.test.config.JpaConfig;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class UserTest {

    @Autowired
    @Qualifier("userDao")
    AbstractDao<User,Integer> daoUser;


    @Autowired
    @Qualifier("roleDao")
    AbstractDao<Role,Integer> daoRole;

    @Autowired
    @Qualifier("privilegesDao")
    AbstractDao<Privileges,Integer> daoPriveleges;

    @Autowired
    @Qualifier("ratingDao")
    AbstractDao<Rating,Integer> daoRating;

    @Test
    public void userTest(){
        daoRole.insertObject(new Role("UserTest"));
        Role role=daoRole.selectObject(1);
        assert role.getName().equals("UserTest") :"role dont work insert";

        daoPriveleges.insertObject(new Privileges("show product"));
        Privileges privileges=daoPriveleges.selectObject(1);
        assert privileges.getName().equals("show product") : "dont work privileges";

        daoUser.insertObject(new User("Petushok","Ilya","Aleksandrovich","login","pass","a33@mail",new Role(1)));
        User user=daoUser.selectObject(1);
        assert user.getSurname().equals("Petushok") : "dont work insert user";
    }
}
