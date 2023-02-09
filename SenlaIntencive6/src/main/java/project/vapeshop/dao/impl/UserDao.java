package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDao implements Dao<User> {
    private static final List<User> users = new ArrayList<>();

    @Override
    public boolean insertObject(User user) {
        user.setId(users.size());
        users.add(user);
        return true;
    }

    @Override
    public boolean insertObjects(List<User> t) {
        for (User user : t) {
            user.setId(users.size());
            users.add(user);
        }
        return true;
    }

    @Override
    public List<User> selectObjects() {
        return users;
    }

    @Override
    public User selectObject(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public User update(User user) {
        User user1 = users.stream()
                .filter(u -> u.getId() == user.getId())
                .findAny()
                .orElse(null);
        if (user1 != null) {
            delete(user.getId());
            users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .map(user -> user.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            users.remove(i.intValue());
            return true;
        }
        return false;
    }
}