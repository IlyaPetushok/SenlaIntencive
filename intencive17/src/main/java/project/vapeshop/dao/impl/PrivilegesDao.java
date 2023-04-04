package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IPrivilegeDao;
import project.vapeshop.entity.user.Privileges;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PrivilegesDao extends AbstractDao<Privileges,Integer> implements IPrivilegeDao {
    @Override
    public List<Privileges> selectObjects() {
        Query query=entityManager.createQuery("Select priv from Privileges as priv");
        return query.getResultList();
    }

    @Override
    public Privileges selectObject(Integer id) {
        return entityManager.find(Privileges.class,id);
    }
}
