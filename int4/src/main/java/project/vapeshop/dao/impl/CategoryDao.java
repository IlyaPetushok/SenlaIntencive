package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CategoryDao extends AbstrarctDao<Category,Integer> {
    private static final List<Category> categories = new ArrayList<>();

    public CategoryDao() {
        super(categories);
    }
}
