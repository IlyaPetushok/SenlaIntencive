package project.vapeshop.dao.impl;

import project.vapeshop.entity.EntityGetSetId;
import project.vapeshop.entity.product.Item;

import java.util.List;
import java.util.Objects;

public abstract class AbstractDao <T extends EntityGetSetId>{
    public List<T> selects(List<T> t) {
        return t;
    }

    public T select(List<T> t,int id) {
        return t.stream()
                .filter(t1 -> t1.getId() == id)
                .findAny()
                .orElse(null);
    }

    public List<T> insert(List<T> tList,T t) {
        t.setId(tList.size());
        tList.add(t);
        return tList;
    }
}
