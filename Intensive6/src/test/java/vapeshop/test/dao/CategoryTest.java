package vapeshop.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.entity.product.Category;
import vapeshop.test.config.JpaConfig;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfig.class})
@Transactional
public class CategoryTest {
    @Autowired
    @Qualifier("categoryDao")
    AbstractDao<Category, Integer> dao;

    @Test
    public void createCategoryTest(){
        Category category = new Category("тест категори");
        dao.insertObject(category);
        Category category1 = dao.selectObject(4);
        assert category1.getName().equals("тест категори") : "проблемы с category";
    }

    @Test
    public void selectCategoryTest(){
        Category category1 = dao.selectObject(1);
        assert category1.getName().equals("Жидкости") : "проблемы с category";
    }

    @Test
    public void deleteCategoryTest(){
        Category category = new Category("тест категори");
        dao.insertObject(category);
        List<Category> categoryList= dao.selectObjects();
        int id= dao.selectObjects().get(categoryList.size()-1).getId();
        dao.delete(id);
        assert dao.selectObjects().size()!=categoryList.size():"проблемы с category";
    }

    @Test
    public void updateCategoryTest(){
        Category category = new Category("тест категори");
        dao.insertObject(category);
        List<Category> categoryList= dao.selectObjects();
        int id= dao.selectObjects().get(categoryList.size()-1).getId();
        dao.update(new Category(id,"test category update"));
        Category category1 = dao.selectObject(id);
        assert category1.getName().equals("test category update") : "проблемы с category";
    }
}
