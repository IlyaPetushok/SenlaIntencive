package project.vapeshop.mapper.impl.product;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.product.VaporizerDTO;
import project.vapeshop.entity.product.Vaporizer;
import project.vapeshop.mapper.Mapper;
import java.util.List;

@Component
public class VaporizerMapper implements Mapper<Vaporizer, VaporizerDTO> {
    @Override
    public VaporizerDTO toDTO(Vaporizer vaporizer) {
        return new VaporizerDTO(vaporizer.getId(), vaporizer.getResistance(), vaporizer.getType());
    }

    @Override
    public List<VaporizerDTO> toDTOs(List<Vaporizer> vaporizerEntities) {
        return vaporizerEntities.stream()
                .map(vaporizer -> new VaporizerDTO(vaporizer.getId(), vaporizer.getResistance(), vaporizer.getType()))
                .toList();
    }

    @Override
    public Vaporizer toEntity(VaporizerDTO vaporizerDTO) {
        return new Vaporizer(vaporizerDTO.getId(), vaporizerDTO.getResistance(), vaporizerDTO.getType());
    }

    @Override
    public List<Vaporizer> toEntities(List<VaporizerDTO> vaporizerDTOs) {
        return vaporizerDTOs.stream()
                .map(vaporizerDTO -> new Vaporizer(vaporizerDTO.getId(), vaporizerDTO.getResistance(), vaporizerDTO.getType()))
                .toList();
    }
}
