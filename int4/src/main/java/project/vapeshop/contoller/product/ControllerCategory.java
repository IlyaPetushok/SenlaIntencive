package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerCategory {
    CategoryService service;

    @Autowired
    public ControllerCategory(CategoryService service) {
        this.service = service;
    }

    public void execute() {
        if(insert()){
            System.out.println("Объекты юыли добавлены");
        }
        System.out.println(read());
        if(delete()){
            System.out.println("Объекты были удалны");
        }
        if (update() != null) {
            System.out.println("Был обнавлён");
        }        System.out.println(read());
    }

    private boolean insert() {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryDTOList.add(new CategoryDTO("Вейп"));
        categoryDTOList.add(new CategoryDTO("Жидкость"));
        return service.addObjects(categoryDTOList);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for (CategoryDTO categoryDTO : service.showObjects()) {
            stringList.add(MapperJson.mapperToJson(categoryDTO));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(1);
    }

    public CategoryDTO update() {
        return service.updateObject(new CategoryDTO("Испаритель"));
    }
}
