package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOFullInfo;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Vape;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class VapeService {
    Dao<Vape,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public VapeService(Dao<Vape,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public VapeDTO showItem(int id) {
        return modelMapper.map(dao.selectObject(id),VapeDTO.class);
    }

    public List<VapeDTO> showItems() {
        return dao.selectObjects().stream()
                .map(vape -> modelMapper.map(vape,VapeDTO.class))
                .collect(Collectors.toList());
    }

    public VapeDTO addItem(VapeDTO vapeDTO) {
        VapeDTO vapeDTO1=modelMapper.map(dao.insertObject(modelMapper.map(vapeDTO,Vape.class)),VapeDTO.class);
        return vapeDTO1;
    }

    public List<VapeDTO> addItems(List<VapeDTO> vapeDTO) {
        List<Vape> vape=dao.insertObjects(vapeDTO.stream()
                .map(vapeDTO1 -> modelMapper.map(vapeDTO1,Vape.class))
                .collect(Collectors.toList()));
        return vape.stream()
                .map(vape1 -> modelMapper.map(vape1,VapeDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public VapeDTO updateItem(VapeDTO vapeDTO) {
        return modelMapper.map(dao.update(modelMapper.map(vapeDTO,Vape.class)),VapeDTO.class);
    }
}
