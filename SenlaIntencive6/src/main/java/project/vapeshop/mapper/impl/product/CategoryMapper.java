package project.vapeshop.mapper.impl.product;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.entity.product.Category;
import project.vapeshop.mapper.Mapper;
import java.util.List;
import java.util.Objects;

@Component
public class CategoryMapper implements Mapper<Category, CategoryDTO> {

    @Override
    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }

    @Override
    public List<CategoryDTO> toDTOs(List<Category> categoryEntities) {
        return categoryEntities.stream()
                .filter(Objects::nonNull)
                .map(category -> new CategoryDTO(category.getId(), category.getName()))
                .toList();
    }

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getId(), categoryDTO.getName());
    }

    @Override
    public List<Category> toEntities(List<CategoryDTO> categoryDTOs) {
        return categoryDTOs.stream()
                .map(category->new Category(category.getId(), category.getName()))
                .toList();
    }
}
