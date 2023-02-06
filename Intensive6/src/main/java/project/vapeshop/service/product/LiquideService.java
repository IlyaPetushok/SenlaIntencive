package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.entity.product.Liquide;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LiquideService {
    Dao<Liquide> dao;
    ModelMapper modelMapper;

    @Autowired
    public LiquideService(Dao<Liquide> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public LiquideDTO showItem(int id) {
        return modelMapper.map(dao.selectObject(id),LiquideDTO.class);
    }

    public List<LiquideDTO> showItems() {
        return dao.selectObjects().stream()
                .map(liquide -> modelMapper.map(liquide,LiquideDTO.class))
                .collect(Collectors.toList());
    }

    public boolean addItem(LiquideDTO liquideDTO) {
        return dao.insertObject(modelMapper.map(liquideDTO,Liquide.class));
    }

    public boolean addItems(List<LiquideDTO> liquideDTO) {
        return dao.insertObjects(liquideDTO.stream()
                .map(liquideDTO1 -> modelMapper.map(liquideDTO1,Liquide.class))
                .collect(Collectors.toList()));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public LiquideDTO updateItem(LiquideDTO liquideDTO) {
        return modelMapper.map(dao.update(modelMapper.map(liquideDTO,Liquide.class)),LiquideDTO.class);
    }
}
