package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IVaporizerDao;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.Vaporizer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class VaporizerService {
    IVaporizerDao dao;
    ModelMapper modelMapper;

    @Autowired
    public VaporizerService(IVaporizerDao dao, ModelMapper modelMapper) {
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

    @Transactional
    public VaporizerDTO addItem(VaporizerDTO vaporizerDTO) {
        return modelMapper.map(dao.insertObject(modelMapper.map(vaporizerDTO, Vaporizer.class)),VaporizerDTO.class);
    }

    @Transactional
    public List<VaporizerDTO> addItems(List<VaporizerDTO> vaporizerDTO) {
        List<Vaporizer> vaporizers=dao.insertObjects(vaporizerDTO.stream()
                .map(vaporizerDTO1 -> modelMapper.map(vaporizerDTO1, Vaporizer.class))
                .collect(Collectors.toList()));
        return vaporizers.stream()
                .map(vaporizer -> modelMapper.map(vaporizer, VaporizerDTO.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    @Transactional
    public VaporizerDTO updateItem(VaporizerDTO vaporizerDTO) {
        return modelMapper.map(dao.update(modelMapper.map(vaporizerDTO,Vaporizer.class)),VaporizerDTO.class);
    }

    public List<VaporizerDTO> showVapeByType(String type){
        return dao.findByTypeVaporizer(type).stream()
                .map(vape -> modelMapper.map(vape,VaporizerDTO.class))
                .collect(Collectors.toList());
    }
}
