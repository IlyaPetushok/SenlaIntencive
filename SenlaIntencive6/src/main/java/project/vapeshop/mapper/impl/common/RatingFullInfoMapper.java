package project.vapeshop.mapper.impl.common;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class RatingFullInfoMapper implements Mapper<Rating, RatingDTOFullInfo> {
    @Override
    public RatingDTOFullInfo toDTO(Rating rating) {
        return null;
    }

    @Override
    public List<RatingDTOFullInfo> toDTOs(List<Rating> ratingEntities) {
        return null;
    }

    @Override
    public Rating toEntity(RatingDTOFullInfo ratingDTOFullInfo) {
        return new Rating(ratingDTOFullInfo.getId(),ratingDTOFullInfo.getComment(), ratingDTOFullInfo.getQuantityStar(), ratingDTOFullInfo.getIdItem(), ratingDTOFullInfo.getIdUser());
    }

    @Override
    public List<Rating> toEntities(List<RatingDTOFullInfo> ratingDTOFullInfos) {
//        можно ли добавлять список коментов(думаю безсмысленный метод)
        return ratingDTOFullInfos.stream()
                .map(ratingDTOFullInfo -> new Rating(ratingDTOFullInfo.getId(),ratingDTOFullInfo.getComment(), ratingDTOFullInfo.getQuantityStar(), ratingDTOFullInfo.getIdItem(), ratingDTOFullInfo.getIdUser()))
                .toList();
    }
}
