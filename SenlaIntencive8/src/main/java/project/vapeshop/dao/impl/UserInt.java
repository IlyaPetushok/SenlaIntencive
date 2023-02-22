package project.vapeshop.dao.impl;

import project.vapeshop.dao.Dao;
import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.user.User;

public interface UserInt extends Dao<User,Integer> {
    User findByLoginAndPassword(User user);
    User findByLogin(String  login);
}
