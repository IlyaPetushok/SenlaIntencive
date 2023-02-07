package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.entity.product.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ItemDao extends AbstrarctDao<Item,Integer> {
    private static final List<Item> items = new ArrayList<>();

    public ItemDao() {
        super(items);
    }
}
