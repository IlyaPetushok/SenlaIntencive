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

    @Override
    public List<Category> selectObjects() {
        Query query= entityManager.createQuery("SELECT cat FROM Category as cat");
        return query.getResultList();
    }

    @Override
    public Category selectObject(Integer id) {
        Query query= entityManager.createQuery("SELECT cat FROM Category as cat where cat.id=?1");
        query.setParameter(1,id);
        return (Category) query.getSingleResult();
    }

    @Override
    public Category update(Category category) {
        Category category1=entityManager.find(Category.class,category.getId());
        category1.setName("Одноразки");
        return category1;
    }
}
