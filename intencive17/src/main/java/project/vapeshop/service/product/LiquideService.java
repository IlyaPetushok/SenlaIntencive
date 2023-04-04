package project.vapeshop.service.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.ILiquideDao;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.dto.product.LiquideDTOFullInfo;
import project.vapeshop.entity.product.Liquide;
import project.vapeshop.entity.type.LiquideTypeNicotine;

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
        return modelMapper.map(dao.selectObject(id), LiquideDTOFullInfo.class);
    }

    public List<LiquideDTO> showItems() {
        List<LiquideDTO> liquideDTOFullInfoList =dao.selectObjects().stream()
                .map(liquide -> modelMapper.map(liquide, LiquideDTO.class))
                .collect(Collectors.toList());
        return liquideDTOFullInfoList;
    }

    @Transactional
    public LiquideDTOFullInfo addItem(LiquideDTOFullInfo liquideDTOFullInfo) {
        return modelMapper.map(dao.insertObject(modelMapper.map(liquideDTOFullInfo,Liquide.class)), LiquideDTOFullInfo.class);
    }


    @Transactional
    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    @Transactional
    public LiquideDTOFullInfo updateItem(LiquideDTOFullInfo liquideDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(liquideDTOFullInfo,Liquide.class)), LiquideDTOFullInfo.class);
    }

    public List<LiquideDTO> showLiquideByNicotine(String typeNicotine){
        return dao.findByTypeNicotine(LiquideTypeNicotine.getTypeValue(typeNicotine)).stream()
                .map(liquide -> modelMapper.map(liquide, LiquideDTO.class))
                .collect(Collectors.toList());
    }
}
