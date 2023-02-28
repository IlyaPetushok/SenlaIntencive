package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.entity.product.Vape;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class VapeService {
    AbstractDao<Vape,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public VapeService(AbstractDao<Vape,Integer> dao, ModelMapper modelMapper) {
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

    @Transactional
    public boolean addItem(VapeDTO vapeDTO) {
        return dao.insertObject(modelMapper.map(vapeDTO,Vape.class));
    }

    @Transactional
    public boolean addItems(List<VapeDTO> vapeDTO) {
        return dao.insertObjects(vapeDTO.stream()
                .map(vapeDTO1 -> modelMapper.map(vapeDTO1,Vape.class))
                .collect(Collectors.toList()));
    }

    @Transactional
    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    @Transactional
    public VapeDTO updateItem(VapeDTO vapeDTO) {
        return modelMapper.map(dao.update(modelMapper.map(vapeDTO,Vape.class)),VapeDTO.class);
    }
}
