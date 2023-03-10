package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.ICategoryDao;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.entity.product.Category;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class CategoryService{
    ICategoryDao dao;
    ModelMapper modelMapper;

    public CategoryService() {
    }

    @Autowired
    public CategoryService(ICategoryDao dao, ModelMapper modelMapper) {
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
    public CategoryDTO addObject(CategoryDTO categoryDTO) {
        return modelMapper.map(dao.insertObject(modelMapper.map(categoryDTO,Category.class)),CategoryDTO.class);
    }

    @Transactional
    public List<CategoryDTO> addObjects(List<CategoryDTO> categoryDTO) {
        List<Category> categories= dao.insertObjects(categoryDTO.stream()
                .map(catDto -> modelMapper.map(catDto,Category.class))
                .collect(Collectors.toList()));
        return categories.stream().map(category -> modelMapper.map(category,CategoryDTO.class)).collect(Collectors.toList());
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
