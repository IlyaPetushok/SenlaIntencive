package project.vapeshop.mapper.impl.product;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.VapeDTO;
import project.vapeshop.entity.product.Vape;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class VapeMapper implements Mapper<Vape, VapeDTO> {
    @Override
    public VapeDTO toDTO(Vape vape) {
        return new VapeDTO(vape.getId(), vape.getPower(), vape.getBattery(), vape.getType());
    }

    @Override
    public List<VapeDTO> toDTOs(List<Vape> vapeEntities) {
        return vapeEntities.stream()
                .map(vape -> new VapeDTO(vape.getId(), vape.getPower(), vape.getBattery(), vape.getType()))
                .toList();
    }

    @Override
    public Vape toEntity(VapeDTO vapeDTO) {
        return new Vape(vapeDTO.getId(), vapeDTO.getPower(), vapeDTO.getBattery(), vapeDTO.getType());
    }

    @Override
    public List<Vape> toEntities(List<VapeDTO> vapeDTOs) {
        return vapeDTOs.stream()
                .map(vapeDTO -> new Vape(vapeDTO.getId(), vapeDTO.getPower(), vapeDTO.getBattery(), vapeDTO.getType()))
                .toList();
    }
}
