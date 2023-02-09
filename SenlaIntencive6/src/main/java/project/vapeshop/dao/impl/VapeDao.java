package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Vape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VapeDao implements Dao<Vape> {
    private static final List<Vape> vapes = new ArrayList<>();

    @Override
    public boolean insertObject(Vape vape) {
        vape.setId(vapes.size());
        vapes.add(vape);
        return true;
    }

    @Override
    public boolean insertObjects(List<Vape> t) {
        for (Vape vape : t) {
            vape.setId(vapes.size());
            vapes.add(vape);
        }
        return true;
    }

    @Override
    public List<Vape> selectObjects() {
        return vapes;
    }

    @Override
    public Vape selectObject(int id) {
        return vapes.stream()
                .filter(vape -> vape.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Vape update(Vape vape) {
        Vape vape1 = vapes.stream()
                .filter(v -> v.getId() == vape.getId())
                .findAny()
                .orElse(null);
        if (vape1 != null) {
            delete(vape1.getId());
            vapes.add(vape);
            return vape;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = vapes.stream()
                .filter(rating -> Objects.equals(rating.getId(), id))
                .map(rating -> rating.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            vapes.remove(i.intValue());
            return true;
        }
        return false;
    }
}