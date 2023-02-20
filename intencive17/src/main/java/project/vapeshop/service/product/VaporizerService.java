package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.product.Vaporizer;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaporizerService {
    Dao<Vaporizer,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public VaporizerService(Dao<Vaporizer,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public VaporizerDTO showItem(int id) {
        return modelMapper.map(dao.selectObject(id), VaporizerDTO.class);
    }

    public List<VaporizerDTO> showItems() {
        return dao.selectObjects().stream()
                .map(vaporizer -> modelMapper.map(vaporizer, VaporizerDTO.class))
                .collect(Collectors.toList());
    }

    public VaporizerDTO addItem(VaporizerDTO vaporizerDTO) {
        return modelMapper.map(dao.insertObject(modelMapper.map(vaporizerDTO, Vaporizer.class)),VaporizerDTO.class);
    }

    public List<VaporizerDTO> addItems(List<VaporizerDTO> vaporizerDTO) {
        List<Vaporizer> vaporizers=dao.insertObjects(vaporizerDTO.stream()
                .map(vaporizerDTO1 -> modelMapper.map(vaporizerDTO1, Vaporizer.class))
                .collect(Collectors.toList()));
        return vaporizers.stream()
                .map(vaporizer -> modelMapper.map(vaporizer, VaporizerDTO.class))
                .collect(Collectors.toList());
    }


    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public VaporizerDTO updateItem(VaporizerDTO vaporizerDTO) {
        return modelMapper.map(dao.update(modelMapper.map(vaporizerDTO,Vaporizer.class)),VaporizerDTO.class);
    }
}
