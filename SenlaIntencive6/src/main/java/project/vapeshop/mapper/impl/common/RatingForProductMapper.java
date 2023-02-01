package project.vapeshop.mapper.impl.common;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.mapper.Mapper;

import java.util.List;


@Component
public class RatingForProductMapper implements Mapper<Rating, RatingDTOForProduct> {
    @Override
    public RatingDTOForProduct toDTO(Rating rating) {
        return null;
    }

    @Override
    public List<RatingDTOForProduct> toDTOs(List<Rating> ratingEntities) {
        return ratingEntities.stream()
                .map(rating -> new RatingDTOForProduct(rating.getId(), rating.getComment(), rating.getQuantityStar(), rating.getIdUser()))
                .toList();
    }

    @Override
    public Rating toEntity(RatingDTOForProduct ratingDTOForProduct) {
        return null;
    }

    @Override
    public List<Rating> toEntities(List<RatingDTOForProduct> ratingDTOForProducts) {
        return null;
    }
}
