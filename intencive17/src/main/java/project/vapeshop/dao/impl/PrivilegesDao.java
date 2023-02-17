package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Privileges;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PrivilegesDao extends AbstractDao<Privileges,Integer> {
    @Override
    public List<Privileges> selectObjects() {
        Query query=entityManager.createQuery("Select priv from Privileges as priv");
        return query.getResultList();
    }

    @Override
    public Privileges selectObject(Integer id) {
        Query query=entityManager.createQuery("select priv From Privileges as priv where priv.id=?1");
        query.setParameter(1,id);
        return (Privileges) query.getSingleResult();
    }

    @Transactional
    @Override
    public Privileges update(Privileges privileges) {
        Privileges privileges1=entityManager.find(Privileges.class,privileges.getId());
        privileges1.setName(privileges.getName());
        return privileges1;
    }
}
