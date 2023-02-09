package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.user.Privileges;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PrivilegesDao implements Dao<Privileges> {
    private static final List<Privileges> privilegesList=new ArrayList<>();
    @Override
    public boolean insertObject(Privileges privileg) {
        privileg.setId(privilegesList.size());
        privilegesList.add(privileg);
        return true;
    }

    @Override
    public boolean insertObjects(List<Privileges> privileges) {
        for (Privileges privilege : privileges) {
            privilege.setId(privilegesList.size());
            privilegesList.add(privilege);
        }
        return true;
    }

    @Override
    public List<Privileges> selectObjects() {
        return privilegesList;
    }

    @Override
    public Privileges selectObject(int id) {
        return privilegesList.stream()
                .filter(priv -> priv.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Privileges update(Privileges privileges) {
        Privileges privileges1 = privilegesList.stream()
                .filter(priv -> priv.getId() == privileges.getId())
                .findAny()
                .orElse(null);
        if (privileges1 != null) {
            delete(privileges1.getId());
            privilegesList.add(privileges);
            return privileges;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
            Integer i=privilegesList.stream()
                    .filter(privileges -> Objects.equals(privileges.getId(), id))
                    .map(privileges ->privileges.getId()).findFirst()
                    .orElse(null);
            if(i!=null){
            privilegesList.remove(i.intValue());
            return true;
            }
            return false;
        }
}