package project.vapeshop.contoller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dto.common.OrderDTOForBasket;
import project.vapeshop.dto.common.OrderDTOFullInfo;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;
import project.vapeshop.mapper.MapperJson;
import project.vapeshop.service.common.OrderService;
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
        insert();
//        System.out.println(read());
//        update();
//        delete();
    }

    private boolean insert() {
        List<Item> itemList=new ArrayList<>();
        itemList.add(new Item(1));
        itemList.add(new Item(2));
        List<OrderDTOFullInfo> orderDTOFullInfos=new ArrayList<>();
        orderDTOFullInfos.add(new OrderDTOFullInfo(new Date(2023, Calendar.FEBRUARY,26), StatusOrder.Sent,150.0,new User(1),itemList));
        orderDTOFullInfos.add(new OrderDTOFullInfo(new Date(2023, Calendar.FEBRUARY,25),StatusOrder.Sent,150.0,new User(2),itemList));
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
        return service.deleteObject(25);
    }

    public OrderDTOForBasket update() {
        List<Item> itemList=new ArrayList<>();
        itemList.add(new Item(1));
        return service.updateObject(new OrderDTOFullInfo(2,new Date(2022, Calendar.FEBRUARY,25),"прибыл",150.0,new User(1),itemList));
    }
}
