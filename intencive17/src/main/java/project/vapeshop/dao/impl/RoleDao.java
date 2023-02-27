package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IRoleDao;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.entity.user.Privileges_;
import project.vapeshop.entity.user.Role;
import project.vapeshop.entity.user.Role_;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RoleDao extends AbstractDao<Role,Integer> implements IRoleDao {

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

    @Override
    public Role update(Role role) {
        Role role1=entityManager.find(Role.class,role.getId());
        role1.setName(role.getName());
        return role1;
    }

    @Override
    public List<Role> selectFindByPrivilege(String namePrivilege) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery= criteriaBuilder.createQuery(Role.class);
        Root<Role> roleRoot=criteriaQuery.from(Role.class);
        Join<Role, Privileges> privilegesJoin=roleRoot.join(Role_.privileges);
        criteriaQuery.where(criteriaBuilder.equal(privilegesJoin.get(Privileges_.name),namePrivilege));
        TypedQuery query= entityManager.createQuery(criteriaQuery);
        List<Role> roles=query.getResultList();
        return roles;
    }
}
