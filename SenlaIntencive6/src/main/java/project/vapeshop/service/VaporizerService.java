package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.Vaporizer;
import project.vapeshop.mapper.Mapper;

import java.util.List;
import java.util.Objects;

@Service
public class VaporizerService {
    Dao<Vaporizer> dao;
    Mapper<Vaporizer,VaporizerDTO> mapper;

    @Autowired
    public VaporizerService(Dao<Vaporizer> dao, Mapper<Vaporizer, VaporizerDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public VaporizerDTO showItem(int id) {
        return mapper.toDTO(dao.selectObject(id));
    }

    public List<VaporizerDTO> showItems() {
        return mapper.toDTOs(dao.selectObjects());
    }

    public boolean addItem(VaporizerDTO vaporizerDTO) {
        return dao.insertObject(mapper.toEntity(vaporizerDTO));
    }

    public boolean addItems(List<VaporizerDTO> vaporizerDTO) {
        return dao.insertObjects(mapper.toEntities(vaporizerDTO));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public VaporizerDTO updateItem(VaporizerDTO vaporizerDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(vaporizerDTO)));
    }
}
