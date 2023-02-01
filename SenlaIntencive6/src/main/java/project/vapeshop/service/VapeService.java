package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.entity.product.Vape;
import project.vapeshop.mapper.Mapper;

import java.util.List;
import java.util.Objects;

@Service
public class VapeService {
    Dao<Vape> dao;
    Mapper<Vape,VapeDTO> mapper;

    @Autowired
    public VapeService(Dao<Vape> dao, Mapper<Vape, VapeDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public VapeDTO showItem(int id) {
        return mapper.toDTO(dao.selectObject(id));
    }

    public List<VapeDTO> showItems() {
        return mapper.toDTOs(dao.selectObjects());
    }

    public boolean addItem(VapeDTO vapeDTO) {
        return dao.insertObject(mapper.toEntity(vapeDTO));
    }

    public boolean addItems(List<VapeDTO> vapeDTO) {
        return dao.insertObjects(mapper.toEntities(vapeDTO));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public VapeDTO updateItem(VapeDTO vapeDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(vapeDTO)));
    }
}
