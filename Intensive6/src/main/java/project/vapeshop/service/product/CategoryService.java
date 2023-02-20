package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.entity.product.Category;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CategoryService{
    AbstractDao<Category,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public CategoryService(AbstractDao<Category,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public CategoryDTO showObject(int id) {
        return modelMapper.map(dao.selectObject(id),CategoryDTO.class);
    }

    public List<CategoryDTO> showObjects() {
        return dao.selectObjects().stream().map(category -> modelMapper.map(category,CategoryDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public boolean addObject(CategoryDTO categoryDTO) {
        return dao.insertObject(modelMapper.map(categoryDTO,Category.class));
    }

    @Transactional
    public boolean addObjects(List<CategoryDTO> categoryDTO) {
        return dao.insertObjects(categoryDTO.stream().map(categoryDTO1 -> modelMapper.map(categoryDTO1,Category.class)).collect(Collectors.toList()));
    }

    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public CategoryDTO updateObject(CategoryDTO categoryDTO) {
        return modelMapper.map(dao.update(modelMapper.map(categoryDTO,Category.class)),CategoryDTO.class);
    }
}
