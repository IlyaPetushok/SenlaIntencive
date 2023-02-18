package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Liquide;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LiquideService {
    Dao<Liquide,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public LiquideService(Dao<Liquide,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public LiquideDTO showItem(int id) {
        return modelMapper.map(dao.selectObject(id),LiquideDTO.class);
    }

    public List<LiquideDTO> showItems() {
        List<LiquideDTO> liquideDTOList=dao.selectObjects().stream()
                .map(liquide -> modelMapper.map(liquide, LiquideDTO.class))
                .collect(Collectors.toList());
        return liquideDTOList;
    }

    public LiquideDTO addItem(LiquideDTO liquideDTO) {
        return modelMapper.map(dao.insertObject(modelMapper.map(liquideDTO,Liquide.class)),LiquideDTO.class);
    }


    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public LiquideDTO updateItem(LiquideDTO liquideDTO) {
        return modelMapper.map(dao.update(modelMapper.map(liquideDTO,Liquide.class)),LiquideDTO.class);
    }
}
