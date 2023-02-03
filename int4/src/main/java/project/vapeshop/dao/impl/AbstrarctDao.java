package project.vapeshop.dao.impl;

import project.vapeshop.dao.Dao;
import project.vapeshop.entity.Entity;
import project.vapeshop.entity.product.Item;

import java.util.List;
import java.util.Objects;

public abstract class AbstrarctDao<T extends Entity> implements Dao<T> {

    List<T> tList;
    public AbstrarctDao(List<T> tList) {
        this.tList=tList;
    }

    @Override
    public boolean insertObject(T t) {
        t.setId(tList.size());
        tList.add(t);
        return false;
    }

    @Override
    public boolean insertObjects(List<T> tList) {
        for (T t : tList) {
            this.insertObject(t);
        }
        return true;
    }

    @Override
    public List<T> selectObjects() {
        return tList;
    }

    @Override
    public T selectObject(int id) {
        return tList.stream()
                .filter(t -> t.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public T update(T t) {
        T t1 = tList.stream()
                .filter(t2 -> t2.getId() == t.getId())
                .findAny()
                .orElse(null);
        if (t1 != null) {
            delete(t1.getId());
            tList.add(t);
            return t;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = tList.stream()
                .filter(t -> Objects.equals(t.getId(), id))
                .map(t -> t.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            tList.remove(i.intValue());
            return true;
        }
        return false;
    }
}
