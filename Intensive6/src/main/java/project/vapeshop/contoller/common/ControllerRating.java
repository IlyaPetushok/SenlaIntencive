package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.dto.common.RatingDTOFullInfo;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.common.RatingService;

import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerRating {
    RatingService service;

    @Autowired
    public ControllerRating(RatingService service) {
        this.service = service;
    }

    public void execute() {
//        insert();
//        System.out.println(read());
//        update();
        delete();
    }

    private boolean insert() {
        List<RatingDTOFullInfo> ratingDTOFullInfos = new ArrayList<>();
        ratingDTOFullInfos.add(new RatingDTOFullInfo("good", 5, new Item(1), new User(1)));
        ratingDTOFullInfos.add(new RatingDTOFullInfo("not bad", 3, new Item(1), new User(2)));
        return service.addObjects(ratingDTOFullInfos);
    }

    public List<String> read() {
        List<String> stringList = new ArrayList<>();
        for (RatingDTOForProduct ratingDTOForProduct : service.showObjects()) {
            stringList.add(MapperJson.mapperToJson(ratingDTOForProduct));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(4);
    }

    public RatingDTOForProduct update() {
        return service.updateObject(new RatingDTOFullInfo(4, "good", 3, new Item(1), new User(2)));
    }
}
