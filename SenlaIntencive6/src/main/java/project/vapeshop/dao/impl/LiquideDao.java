package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Liquide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class LiquideDao implements Dao<Liquide> {
    private static final List<Liquide> liquides = new ArrayList<>();

    @Override
    public boolean insertObject(Liquide liquide) {
        liquide.setId(liquides.size());
        liquides.add(liquide);
        return true;
    }

    @Override
    public boolean insertObjects(List<Liquide> liquid) {
        for (Liquide liquide : liquid) {
            liquide.setId(liquides.size());
            liquides.add(liquide);
        }
        return true;
    }

    @Override
    public List<Liquide> selectObjects() {
        return liquides;
    }

    @Override
    public Liquide selectObject(int id) {
        return liquides.stream()
                .filter(item -> item.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public Liquide update(Liquide liquide) {
        Liquide liquide1 = liquides.stream()
                .filter(liq -> liq.getId() == liquide.getId())
                .findAny()
                .orElse(null);
        if (liquide1 != null) {
            delete(liquide1.getId());
            liquides.add(liquide);
            return liquide;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = liquides.stream()
                .filter(category -> Objects.equals(category.getId(), id))
                .map(category -> category.getId()).findFirst().orElse(null);
        System.out.println("i" + i);
        if (i != null) {
            liquides.remove(i.intValue());
            return true;
        }
        return false;
    }
}
