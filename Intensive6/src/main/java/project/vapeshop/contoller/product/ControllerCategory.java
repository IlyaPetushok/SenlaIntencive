package project.vapeshop.contoller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.product.CategoryService;

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
//        insert();
        System.out.println(read());
        delete();
        update();
        System.out.println(read());
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
        System.out.println("selid"+MapperJson.mapperToJson(service.showObject(1)));
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(4);
    }

    public CategoryDTO update() {
        return service.updateObject(new CategoryDTO(4,"Испаритель"));
    }
}
