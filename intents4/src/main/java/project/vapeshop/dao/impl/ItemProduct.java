package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ItemProduct extends AbstractDao<Item> implements Dao<Item>{
    private static List<Item> items = new ArrayList<>();

    @Override
    public boolean insertObject(Item item) {
        items=insert(items,item);
        return true;
    }

    @Override
    public boolean insertObjects(List<Item> itemEntities) {
        for (Item itemEntity : itemEntities) {
            itemEntity.setId(items.size());
            items.add(itemEntity);
        }
        return true;
    }

    @Override
    public List<Item> selectObjects() {
        return selects(items);
    }

    @Override
    public Item selectObject(int id) {
        return select(items,id);
    }

    @Override
    public Item update(Item item) {
        Item item1 = items.stream()
                .filter(itemSt -> itemSt.getId() == item.getId())
                .findAny()
                .orElse(null);
        if (item1 != null) {
            delete(item1.getId());
            items.add(item);
            return item;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i = items.stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .map(item -> item.getId()).findFirst()
                .orElse(null);
        if (i != null) {
            items.remove(i.intValue());
            return true;
        }
        return false;
    }
}
