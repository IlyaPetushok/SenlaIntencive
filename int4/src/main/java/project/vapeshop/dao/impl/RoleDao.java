package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class RoleDao extends AbstrarctDao<Role,Integer> {
    private static final List<Role> roles = new ArrayList<>();


    public RoleDao() {
        super(roles);
    }
}
