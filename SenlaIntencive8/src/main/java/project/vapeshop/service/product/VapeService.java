package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IVapeDao;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.dto.product.VapeDTOFullInfo;
import project.vapeshop.entity.product.Vape;
import project.vapeshop.entity.type.VapeType;
import project.vapeshop.exception.NotFoundException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class VapeService {
    IVapeDao dao;
    ModelMapper modelMapper;

    @Autowired
    public VapeService(IVapeDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public VapeDTOFullInfo showItem(int id) {
        try {
            return modelMapper.map(dao.selectObject(id), VapeDTOFullInfo.class);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "vape dont found");
        }
    }

    public List<VapeDTO> showItems() {
        List<Vape> vapes = dao.selectObjects();
        if (vapes.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "vape list is empty");
        }
        return vapes.stream()
                .map(vape -> modelMapper.map(vape, VapeDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public VapeDTOFullInfo addItem(VapeDTOFullInfo vapeDTOFullInfo) {
        VapeDTOFullInfo vapeDTOFullInfo1 = modelMapper.map(dao.insertObject(modelMapper.map(vapeDTOFullInfo, Vape.class)), VapeDTOFullInfo.class);
        return vapeDTOFullInfo1;
    }

    @Transactional
    public List<VapeDTOFullInfo> addItems(List<VapeDTOFullInfo> vapeDTOFullInfo) {
        List<Vape> vape = dao.insertObjects(vapeDTOFullInfo.stream()
                .map(vapeDTO1 -> modelMapper.map(vapeDTO1, Vape.class))
                .collect(Collectors.toList()));
        return vape.stream()
                .map(vape1 -> modelMapper.map(vape1, VapeDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteItem(int id) {
        try {
            return dao.delete(id);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "vape dont found");
        }
    }

    @Transactional
    public VapeDTOFullInfo updateItem(VapeDTOFullInfo vapeDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(vapeDTOFullInfo, Vape.class)), VapeDTOFullInfo.class);
    }

    public List<VapeDTO> showVapeByType(String type) {
        List<Vape> vapes=dao.findByTypeVape(VapeType.getTypeValue(type));
        if(vapes.isEmpty()){
            throw new NotFoundException(HttpStatus.NOT_FOUND, "vape list is empty");
        }
        return vapes.stream()
                .map(vape -> modelMapper.map(vape, VapeDTO.class))
                .collect(Collectors.toList());
    }
}
