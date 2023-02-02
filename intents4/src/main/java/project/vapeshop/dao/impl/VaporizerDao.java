package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Vaporizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VaporizerDao extends AbstractDao<Vaporizer> implements Dao<Vaporizer> {
    private static List<Vaporizer> vaporizers = new ArrayList<>();

    @Override
    public boolean insertObject(Vaporizer vaporizer) {
        vaporizers=insert(vaporizers,vaporizer);
        return true;
    }

    @Override
    public boolean insertObjects(List<Vaporizer> t) {
        for (Vaporizer vaporizer : t) {
            vaporizer.setId(vaporizers.size());
            vaporizers.add(vaporizer);
        }
        return true;
    }

    @Override
    public List<Vaporizer> selectObjects() {
        return selects(vaporizers);
    }

    @Override
    public Vaporizer selectObject(int id) {
        return select(vaporizers,id);
    }

    @Override
    public Vaporizer update(Vaporizer vaporizer) {
        Vaporizer vaporizer1 = vaporizers.stream()
                .filter(vapor -> vapor.getId() == vaporizer.getId())
                .findAny()
                .orElse(null);
        if (vaporizer1 != null) {
            delete(vaporizer1.getId());
            vaporizers.add(vaporizer);
            return vaporizer;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = vaporizers.stream()
                .filter(vaporizer -> Objects.equals(vaporizer.getId(), id))
                .map(vaporizer -> vaporizer.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            vaporizers.remove(i);
            return true;
        }
        return false;
    }
}
