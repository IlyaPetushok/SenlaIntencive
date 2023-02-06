package project.vapeshop.dao.impl;

import project.vapeshop.dao.Dao;
import project.vapeshop.entity.Entity;

import java.util.List;
import java.util.Objects;

public abstract class AbstrarctDao<T extends Entity,C> implements Dao<T,C> {

    List<T> tList;
    public AbstrarctDao(List<T> tList) {
        this.tList=tList;
    }

    @Override
    public boolean createObject(T t) {
        t.setId(tList.size());
        tList.add(t);
        return false;
    }

    @Override
    public boolean createObjects(List<T> tList) {
        for (T t : tList) {
            this.createObject(t);
        }
        return true;
    }

    @Override
    public List<T> gelAllObjects() {
        return tList;
    }

    public T getByIdObject(C id) {
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
            delete((C) t1.getId());
            tList.add(t);
            return t;
        }
        return null;
    }

    public boolean delete(C id) {
        Integer i = (Integer) tList.stream()
                .filter(t -> Objects.equals(t.getId(), id))
                .map(Entity::getId).findFirst()
                .orElse(null);
        if (i != null) {
            tList.remove(i.intValue());
            return true;
        }
        return false;
    }
}
