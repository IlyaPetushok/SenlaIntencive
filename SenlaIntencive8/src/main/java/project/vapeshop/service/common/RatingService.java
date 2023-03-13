package project.vapeshop.service.common;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IRatingDao;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.exception.NotFoundException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class RatingService {
    IRatingDao dao;
    ModelMapper modelMapper;

    @Autowired
    public RatingService(IRatingDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public RatingDTOForProduct showObject(int id) {
        try {
            return modelMapper.map(dao.selectObject(id), RatingDTOForProduct.class);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "operation is fail because rating dont found");
        }
    }

    public List<RatingDTOForProduct> showObjects() {
        List<Rating> ratings = dao.selectObjects();
        if (ratings.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "ratings list is empty");
        }
        return ratings.stream()
                .map(rating -> modelMapper.map(rating, RatingDTOForProduct.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public RatingDTOFullInfo addObject(RatingDTOFullInfo ratingDTOFullInfo) {
        ratingDTOFullInfo = modelMapper.map(dao.insertObject(modelMapper.map(ratingDTOFullInfo, Rating.class)), RatingDTOFullInfo.class);
        return ratingDTOFullInfo;
    }

    @Transactional
    public List<RatingDTOFullInfo> addObjects(List<RatingDTOFullInfo> ratingDTOFullInfos) {
        List<Rating> ratings = dao.insertObjects(ratingDTOFullInfos.stream()
                .map(ratingDTOFullInfo -> modelMapper.map(ratingDTOFullInfo, Rating.class))
                .collect(Collectors.toList()));
        return ratings.stream()
                .map(rating -> modelMapper.map(rating, RatingDTOFullInfo.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteObject(int id) {
        try {
            return dao.delete(id);
        } catch (NoResultException e) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "rating dont found");
        }
    }

    @Transactional
    public RatingDTOForProduct updateObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return modelMapper.map(dao.update(modelMapper.map(ratingDTOFullInfo, Rating.class)), RatingDTOForProduct.class);
    }
}
