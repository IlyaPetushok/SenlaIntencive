package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.entity.user.Role;
import project.vapeshop.entity.user.User;
import project.vapeshop.entity.user.User_;
import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDao extends AbstractDao<User, Integer> implements UserInt{
    @Override
    public User insertObject(User user) {
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

    @Override
    public User update(User user) {
        User user1=entityManager.find(User.class,user.getId());
        user1.setId(user.getId());
        user1.setLogin(user.getLogin());
        user1.setName(user.getName());
        user1.setMail(user.getMail());
        user1.setPassword(user.getPassword());
        user1.setSurname(user.getSurname());
        user1.setPatronymic(user.getPatronymic());
        Role role=entityManager.find(Role.class,user.getRole().getId());
        user1.setRole(role);
        return user1;
    }




    @Override
    public User findByLoginAndPassword(User user) {
        EntityGraph<?> entityGraph= entityManager.getEntityGraph("entity-user-graph-role");
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery=criteriaBuilder.createQuery(User.class);
        Root<User> userRoot=criteriaQuery.from(User.class);
        Predicate predicateLogin=criteriaBuilder.equal(userRoot.get(User_.login),user.getLogin());
        Predicate predicatePassword=criteriaBuilder.equal(userRoot.get(User_.password),user.getPassword());
        Predicate finalPredicate=criteriaBuilder.and(predicateLogin,predicatePassword);
//        criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.login),user.getLogin()));
//        criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.password),user.getPassword()));
        criteriaQuery.where(finalPredicate);
        TypedQuery<User> query=entityManager.createQuery(criteriaQuery);
        query.setHint("javax.persistence.loadgraph",entityGraph);
        return query.getSingleResult();
    }

    @Override
    public User findByLogin(String login) {
        EntityGraph<?> entityGraph= entityManager.getEntityGraph("entity-user-graph-role");
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery=criteriaBuilder.createQuery(User.class);
        Root<User> userRoot=criteriaQuery.from(User.class);
//        Join<User,Role> roleUserJoin= userRoot.join(User_.role, JoinType.INNER);
//        criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.role),roleUserJoin));
        criteriaQuery.where(criteriaBuilder.equal(userRoot.get(User_.login),login));
        TypedQuery<User> query=entityManager.createQuery(criteriaQuery);
        query.setHint("javax.persistence.loadgraph",entityGraph);
        User user=query.getSingleResult();
        System.out.println(user.getRole().getPrivileges().size());
        user.getRole().setPrivileges(user.getRole().getPrivileges());
        return query.getSingleResult();
    }
}
