package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Role;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RoleDao extends AbstractDao<Role,Integer>{

    public static final String SELECT_ROLE = "SELECT role from Role as role";
    public static final String SELECT_ROLE_ID_1 = "select role from Role as role where role.id=?1 ";

    @Override
    public List<Role> selectObjects() {
        Query query= entityManager.createQuery(SELECT_ROLE);
        return query.getResultList();
    }

    @Override
    public Role selectObject(Integer id) {
        Query query= entityManager.createQuery(SELECT_ROLE_ID_1);
        query.setParameter(1,id);
        return (Role) query.getSingleResult();
    }

    @Transactional
    @Override
    public Role update(Role role) {
        Role role1=entityManager.find(Role.class,role.getId());
        role1.setName(role.getName());
        return role1;
    }
}
