package project.vapeshop.dao;

import project.vapeshop.entity.user.User;

public interface IUserDao extends Dao<User,Integer> {
    User findByLoginAndPassword(User user);
    User findByLogin(String login);
}
