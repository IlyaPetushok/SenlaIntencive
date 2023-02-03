package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.entity.product.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ItemDao extends AbstrarctDao<Item> {
    private static final List<Item> items = new ArrayList<>();

    public ItemDao() {
        super(items);
    }

//    public boolean insertObject(Item item) {
//        return super.insertObject(item);
//    }
//
//    public boolean insertObjects(List<Item> itemEntities) {
//        return super.insertObjects(itemEntities);
//    }
//
//    @Override
//    public List<Item> selectObjects() {
//        return items;
//    }
//
//    @Override
//    public Item selectObject(int id) {
//        return items.stream()
//                .filter(item -> item.getId() == id)
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public Item update(Item item) {
//        Item item1 = items.stream()
//                .filter(itemSt -> itemSt.getId() == item.getId())
//                .findAny()
//                .orElse(null);
//        if (item1 != null) {
//            delete(item1.getId());
//            items.add(item);
//            return item;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        Integer i = items.stream()
//                .filter(item -> Objects.equals(item.getId(), id))
//                .map(item -> item.getId()).findFirst()
//                .orElse(null);
//        if (i != null) {
//            items.remove(i.intValue());
//            return true;
//        }
//        return false;
//    }
}
