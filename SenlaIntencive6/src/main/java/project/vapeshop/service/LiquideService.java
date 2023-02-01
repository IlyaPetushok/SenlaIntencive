package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.entity.product.Liquide;
import project.vapeshop.mapper.Mapper;
import java.util.List;

@Component
public class LiquideService {
    Dao<Liquide> dao;
    Mapper<Liquide,LiquideDTO> mapper;

    @Autowired
    public LiquideService(Dao<Liquide> dao, Mapper<Liquide, LiquideDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public LiquideDTO showItem(int id) {
        return  mapper.toDTO(dao.selectObject(id));
    }

    public List<LiquideDTO> showItems() {
        return  mapper.toDTOs(dao.selectObjects());
    }

    public boolean addItem(LiquideDTO liquideDTO) {
        return dao.insertObject(new Liquide(liquideDTO.getId(), liquideDTO.getFlavour(), liquideDTO.getFortress(), liquideDTO.getTypeNicotine(), liquideDTO.getVolume()));
    }

    public boolean addItems(List<LiquideDTO> liquideDTO) {
        return dao.insertObjects(mapper.toEntities(liquideDTO));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public LiquideDTO updateItem(LiquideDTO liquideDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(liquideDTO)));
    }
}
