package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Privileges;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PrivilegesDao extends AbstrarctDao<Privileges>{
    private static final List<Privileges> privilegesList=new ArrayList<>();


    public PrivilegesDao(List<Privileges> privileges) {
        super(privileges);
    }
}
