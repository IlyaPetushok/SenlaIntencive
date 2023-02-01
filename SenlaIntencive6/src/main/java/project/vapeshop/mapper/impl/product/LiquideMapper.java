package project.vapeshop.mapper.impl.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.LiquideDTO;
import project.vapeshop.entity.product.Liquide;
import project.vapeshop.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class LiquideMapper implements Mapper<Liquide, LiquideDTO> {
//    private final ModelMapper modelMapper=new ModelMapper();


    @Override
    public LiquideDTO toDTO(Liquide liquide) {
//        return modelMapper.map(liquide,LiquideDTO.class);
        return new LiquideDTO(liquide.getId(), liquide.getFlavour(), liquide.getFortress(), liquide.getTypeNicotine(), liquide.getVolume());
    }

    @Override
    public List<LiquideDTO> toDTOs(List<Liquide> liquideEntities) {
//        List<LiquideDTO> liquideDTOList=new ArrayList<>();
//        for (Liquide liquide : liquideEntities) {
//            liquideDTOList.add(modelMapper.map(liquide,LiquideDTO.class));
//        }
//        return liquideDTOList;
        return liquideEntities.stream()
                .map(liquide -> new LiquideDTO(liquide.getId(), liquide.getFlavour(), liquide.getFortress(), liquide.getTypeNicotine(), liquide.getVolume()))
                .toList();
    }

    @Override
    public Liquide toEntity(LiquideDTO liquideDTO) {
//        return modelMapper.map(liquideDTO,Liquide.class);
        return new Liquide(liquideDTO.getId(), liquideDTO.getFlavour(), liquideDTO.getFortress(), liquideDTO.getTypeNicotine(), liquideDTO.getVolume());
    }

    @Override
    public List<Liquide> toEntities(List<LiquideDTO> liquideDTOs) {
//        List<Liquide> liquideList=new ArrayList<>();
//        for (LiquideDTO liquideDTO : liquideDTOs) {
//            liquideList.add(modelMapper.map(liquideDTO,Liquide.class));
//        }
//        return liquideList;
        return liquideDTOs.stream()
                .map(liquideDTO-> new Liquide(liquideDTO.getId(), liquideDTO.getFlavour(), liquideDTO.getFortress(), liquideDTO.getTypeNicotine(), liquideDTO.getVolume()))
                .toList();
    }
}
