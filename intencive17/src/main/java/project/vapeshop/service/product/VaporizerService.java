package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IVaporizerDao;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.dto.product.VaporizerDTOFullInfo;
import project.vapeshop.entity.product.Vaporizer;
import project.vapeshop.entity.type.VaporizerType;

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


    public VaporizerDTOFullInfo showItem(int id) {
        return modelMapper.map(dao.selectObject(id), VaporizerDTOFullInfo.class);
    }

    public List<VaporizerDTO> showItems() {
        return dao.selectObjects().stream()
                .map(vaporizer -> modelMapper.map(vaporizer, VaporizerDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public VaporizerDTOFullInfo addItem(VaporizerDTOFullInfo vaporizerDTOFullInfo) {
        return modelMapper.map(dao.insertObject(modelMapper.map(vaporizerDTOFullInfo, Vaporizer.class)), VaporizerDTOFullInfo.class);
    }

    @Transactional
    public List<VaporizerDTOFullInfo> addItems(List<VaporizerDTOFullInfo> vaporizerDTOFullInfo) {
        List<Vaporizer> vaporizers=dao.insertObjects(vaporizerDTOFullInfo.stream()
                .map(vaporizerDTO1 -> modelMapper.map(vaporizerDTO1, Vaporizer.class))
                .collect(Collectors.toList()));
        return vaporizers.stream()
                .map(vaporizer -> modelMapper.map(vaporizer, VaporizerDTOFullInfo.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    @Transactional
    public VaporizerDTOFullInfo updateItem(VaporizerDTOFullInfo vaporizerDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(vaporizerDTOFullInfo,Vaporizer.class)), VaporizerDTOFullInfo.class);
    }

    public List<VaporizerDTO> showVaporizerByType(String type){
        return dao.findByTypeVaporizer(VaporizerType.getTypeVaporizer(type)).stream()
                .map(vape -> modelMapper.map(vape, VaporizerDTO.class))
                .collect(Collectors.toList());
    }
}
