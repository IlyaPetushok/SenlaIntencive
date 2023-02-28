package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.common.Rating;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class RatingService {
    AbstractDao<Rating,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public RatingService(AbstractDao<Rating,Integer> dao, ModelMapper modelMapper) {
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

    @Transactional
    public boolean addObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return dao.insertObject(modelMapper.map(ratingDTOFullInfo,Rating.class));
    }

    @Transactional
    public boolean addObjects(List<RatingDTOFullInfo> ratingDTOFullInfos) {
        return dao.insertObjects(ratingDTOFullInfos.stream()
                .map(ratingDTOFullInfo -> modelMapper.map(ratingDTOFullInfo,Rating.class))
                .collect(Collectors.toList()));
    }

    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public RatingDTOForProduct updateObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(ratingDTOFullInfo,Rating.class)),RatingDTOForProduct.class);
    }
}
