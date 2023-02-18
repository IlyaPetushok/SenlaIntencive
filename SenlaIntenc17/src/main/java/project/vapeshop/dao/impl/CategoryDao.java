package project.vapeshop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Category;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CategoryDao extends AbstractDao<Category,Integer> {


    public static final String SELECT_CATEGORY_ALL = "SELECT cat FROM Category as cat";
    public static final String SELECT_CAT_WHERE_CAT_ID = "SELECT cat FROM Category as cat where cat.id=?1";


    @Override
    public List<Category> selectObjects() {
        Query query= entityManager.createQuery(SELECT_CATEGORY_ALL);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Category selectObject(Integer id) {
        Query query= entityManager.createQuery(SELECT_CAT_WHERE_CAT_ID);
        query.setParameter(1,id);
        return (Category) query.getSingleResult();
    }

    @Transactional
    @Override
    public Category update(Category category) {
        Category category1=entityManager.find(Category.class,category.getId());
        category1.setName(category.getName());
        return category1;
    }
}
