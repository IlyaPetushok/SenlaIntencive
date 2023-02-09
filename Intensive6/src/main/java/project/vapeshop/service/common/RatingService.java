package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.common.Rating;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {
    Dao<Rating,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public RatingService(Dao<Rating,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public RatingDTOForProduct showObject(int id) {
        return modelMapper.map(dao.selectObject(id),RatingDTOForProduct.class);
    }

    public List<RatingDTOForProduct> showObjects() {
        return dao.selectObjects().stream()
                .map(rating -> modelMapper.map(rating,RatingDTOForProduct.class))
                .collect(Collectors.toList());
    }

    public boolean addObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return dao.insertObject(modelMapper.map(ratingDTOFullInfo,Rating.class));
    }

    public boolean addObjects(List<RatingDTOFullInfo> ratingDTOFullInfos) {
        return dao.insertObjects(ratingDTOFullInfos.stream()
                .map(ratingDTOFullInfo -> modelMapper.map(ratingDTOFullInfo,Rating.class))
                .collect(Collectors.toList()));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public RatingDTOForProduct updateObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(ratingDTOFullInfo,Rating.class)),RatingDTOForProduct.class);
    }
}
