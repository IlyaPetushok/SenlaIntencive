package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.ILiquideDao;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.dto.product.LiquideDTOFullInfo;
import project.vapeshop.entity.product.Liquide;
import project.vapeshop.entity.type.LiquideTypeNicotine;
import project.vapeshop.exception.NotFoundException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class LiquideService {
    ILiquideDao dao;
    ModelMapper modelMapper;

    @Autowired
    public LiquideService(ILiquideDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public LiquideDTOFullInfo showItem(int id) {
        try {
            return modelMapper.map(dao.selectObject(id), LiquideDTOFullInfo.class);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "liquide dont found");
        }
    }

    public List<LiquideDTO> showItems() {
        List<Liquide> liquideList = dao.selectObjects();
        if (liquideList.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "liquide list is empty");
        }
        return liquideList.stream()
                .map(liquide -> modelMapper.map(liquide, LiquideDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public LiquideDTOFullInfo addItem(LiquideDTOFullInfo liquideDTOFullInfo) {
        return modelMapper.map(dao.insertObject(modelMapper.map(liquideDTOFullInfo, Liquide.class)), LiquideDTOFullInfo.class);
    }


    @Transactional
    public boolean deleteItem(int id) {
        try {
            return dao.delete(id);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "liquide dont found");
        }
    }

    @Transactional
    public LiquideDTOFullInfo updateItem(LiquideDTOFullInfo liquideDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(liquideDTOFullInfo, Liquide.class)), LiquideDTOFullInfo.class);
    }

    public List<LiquideDTO> showLiquideByNicotine(String typeNicotine) {
        List<Liquide> liquideList=dao.findByTypeNicotine(LiquideTypeNicotine.getTypeValue(typeNicotine));
        if(liquideList.isEmpty()){
            throw new NotFoundException(HttpStatus.NOT_FOUND, "liquide dont found");
        }
        return liquideList.stream()
                .map(liquide -> modelMapper.map(liquide, LiquideDTO.class))
                .collect(Collectors.toList());
    }
}
