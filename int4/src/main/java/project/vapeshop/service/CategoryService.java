package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.entity.product.Category;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Service
public class CategoryService{
    Dao<Category,Integer> dao;
    Mapper<Category,CategoryDTO> mapper;

    @Autowired
    public CategoryService(Dao<Category,Integer> dao, Mapper<Category,CategoryDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public CategoryDTO showObject(int id) {
        return mapper.toDTO(dao.getByIdObject(id));
    }

    public List<CategoryDTO> showObjects() {
        return mapper.toDTOs(dao.gelAllObjects());
    }

    public boolean addObject(CategoryDTO categoryDTO) {
        return dao.createObject(mapper.toEntity(categoryDTO));
    }

    public boolean addObjects(List<CategoryDTO> categoryDTO) {
        return dao.createObjects(mapper.toEntities(categoryDTO));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public CategoryDTO updateObject(CategoryDTO categoryDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(categoryDTO)));
    }
}
