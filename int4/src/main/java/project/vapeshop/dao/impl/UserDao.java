package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDao extends AbstrarctDao<User> {
    private static final List<User> users = new ArrayList<>();


    public UserDao(List<User> users) {
        super(users);
    }
}
