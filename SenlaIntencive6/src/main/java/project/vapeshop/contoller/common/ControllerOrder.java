package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.OrderService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class ControllerOrder {
    OrderService service;


    @Autowired
    public ControllerOrder(OrderService service) {
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
        List<OrderDTOFullInfo> orderDTOFullInfos=new ArrayList<>();
        orderDTOFullInfos.add(new OrderDTOFullInfo(new Date(2023, Calendar.FEBRUARY,26),0,"отправлен",150.0));
        orderDTOFullInfos.add(new OrderDTOFullInfo(new Date(2023, Calendar.FEBRUARY,25),1,"принят",150.0));
        return service.addObjects(orderDTOFullInfos);
    }

    public List<String> read() {
        List<String> stringList=new ArrayList<>();
        for (OrderDTOForBasket showObject : service.showObjects()) {
            stringList.add(MapperJson.mapperToJson(showObject));
        }
        return stringList;
    }

    public boolean delete() {
        return service.deleteObject(1);
    }

    public OrderDTOForBasket update() {
        return service.updateObject(new OrderDTOFullInfo(0,new Date(2022, Calendar.FEBRUARY,25),1,"прибыл",150.0));
    }
}
