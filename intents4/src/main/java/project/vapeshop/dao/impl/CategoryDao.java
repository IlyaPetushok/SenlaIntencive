package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CategoryDao extends AbstractDao<Category> implements Dao<Category> {
    private static List<Category> categories = new ArrayList<>();

    @Override
    public boolean insertObject(Category category) {
        categories=insert(categories,category);
        return true;
    }

    @Override
    public boolean insertObjects(List<Category> categoryEntities) {
        for (Category categoryEntity : categoryEntities) {
            categoryEntity.setId(categories.size());
            categories.add(categoryEntity);
        }
        return true;
    }

    @Override
    public List<Category> selectObjects() {
        return selects(categories);
    }

    @Override
    public Category selectObject(int id) {
        return select(categories,id);
    }

    @Override
    public Category update(Category category) {
        Category category1 = categories.stream()
                .filter(categorySt -> categorySt.getId() == category.getId())
                .findAny()
                .orElse(null);
        if (category1 != null) {
            delete(category1.getId());
            categories.add(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Integer i=categories.stream()
                .filter(category -> Objects.equals(category.getId(), id))
                .map(Category::getId).findFirst()
                .orElse(null);
        if(i!=null){
        categories.remove(i.intValue());
        return true;
        }
        return false;
    }
}
