package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Rating;
import project.vapeshop.mapper.impl.common.OrderForBasketMapper;
import project.vapeshop.mapper.impl.common.OrderFullInfoMapper;
import project.vapeshop.mapper.impl.common.RatingForProductMapper;
import project.vapeshop.mapper.impl.common.RatingFullInfoMapper;

import java.util.List;

@Service
public class RatingService {
    Dao<Rating> dao;
    RatingForProductMapper ratingForProductMapper;
    RatingFullInfoMapper ratingFullInfoMapper;

    @Autowired
    public RatingService(Dao<Rating> dao, RatingForProductMapper ratingForProductMapper, RatingFullInfoMapper ratingFullInfoMapper) {
        this.dao = dao;
        this.ratingForProductMapper = ratingForProductMapper;
        this.ratingFullInfoMapper = ratingFullInfoMapper;
    }

    public RatingDTOForProduct showObject(int id) {
        return ratingForProductMapper.toDTO(dao.selectObject(id));
    }

    public List<RatingDTOForProduct> showObjects() {
        return ratingForProductMapper.toDTOs(dao.selectObjects());
    }

    public boolean addObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return dao.insertObject(ratingFullInfoMapper.toEntity(ratingDTOFullInfo));
    }

    public boolean addObjects(List<RatingDTOFullInfo> ratingDTOFullInfos) {
        return dao.insertObjects(ratingFullInfoMapper.toEntities(ratingDTOFullInfos));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public RatingDTOForProduct updateObject(RatingDTOFullInfo ratingDTOFullInfo) {
        return ratingForProductMapper.toDTO(dao.update(ratingFullInfoMapper.toEntity(ratingDTOFullInfo)));
    }
}
