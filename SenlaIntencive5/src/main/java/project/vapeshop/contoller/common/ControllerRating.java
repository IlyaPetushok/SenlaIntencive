package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.RatingDTOForProduct;
import project.vapeshop.dto.common.RatingDTOFullInfo;
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
        if(insert()){
            System.out.println("Объекты юыли добавлены");
        }
        System.out.println(read());
        if(delete()){
            System.out.println("Объекты были удалны");
        }
        if (update() != null) {
            System.out.println("Был обнавлён");
        }        System.out.println(read());
    }

    private boolean insert() {
        List<RatingDTOFullInfo> ratingDTOFullInfos=new ArrayList<>();
        ratingDTOFullInfos.add(new RatingDTOFullInfo("good",5,0,0));
        ratingDTOFullInfos.add(new RatingDTOFullInfo("not bad",3,1,1));
        return service.addObjects(ratingDTOFullInfos);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for(RatingDTOForProduct ratingDTOForProduct:service.showObjects()){
            stringList.add(MapperJson.mapperToJson(ratingDTOForProduct));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(1);
    }

    public RatingDTOForProduct update() {
        return service.updateObject(new RatingDTOFullInfo(0,"good",3,0,2));
    }
}
