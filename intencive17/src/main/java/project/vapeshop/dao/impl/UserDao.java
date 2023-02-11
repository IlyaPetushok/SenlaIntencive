package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Role;
import project.vapeshop.entity.user.User;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDao extends AbstractDao<User,Integer> {
    @Override
    public boolean insertObject(User user) {
        Role role=entityManager.find(Role.class,user.getRole().getId());
        user.setRole(role);
        return super.insertObject(user);
    }


    @Override
    public List<User> selectObjects() {
        Query query= entityManager.createQuery("SELECT us from User as us");
        return query.getResultList();
    }

    @Override
    public User selectObject(Integer id) {
        Query query= entityManager.createQuery("SELECT us from User as us where us.id=?1");
        query.setParameter(1,id);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public User update(User user) {
        User user1=entityManager.find(User.class,user.getId());
        user1.setId(user.getId());
        user1.setLogin(user.getLogin());
        user1.setName(user.getName());
        user1.setMail(user.getMail());
        user1.setSurname(user.getSurname());
        user1.setPatronymic(user.getPatronymic());
        Role role=entityManager.find(Role.class,user.getRole().getId());
        user1.setRole(role);
        return user1;
    }
}
