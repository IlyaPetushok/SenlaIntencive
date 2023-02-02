package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RoleDao extends AbstractDao<Role> implements Dao<Role> {
    private static List<Role> roles = new ArrayList<>();

    @Override
    public boolean insertObject(Role role) {
        roles=insert(roles,role);
        return true;
    }

    @Override
    public boolean insertObjects(List<Role> t) {
        for (Role role : t) {
            role.setId(roles.size());
            roles.add(role);
        }
        return true;
    }

    @Override
    public List<Role> selectObjects() {
        return roles;
    }

    @Override
    public Role selectObject(int id) {
        return roles.stream()
                .filter(role -> role.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Role update(Role role) {
        Role role1 = roles.stream()
                .filter(r -> r.getId() == role.getId())
                .findAny()
                .orElse(null);
        if (role1 != null) {
            delete(role1.getId());
            roles.add(role);
            return role;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = roles.stream()
                .filter(role -> Objects.equals(role.getId(), id))
                .map(role -> role.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            roles.remove(i.intValue());
            return true;
        }
        return false;
    }
}
