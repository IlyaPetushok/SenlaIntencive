package project.vapeshop.dao;

import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.user.User;

public interface IUserDao extends Dao<User,Integer> {
    User findByLoginAndPassword(User user);
    User findByLogin(String login);
}
