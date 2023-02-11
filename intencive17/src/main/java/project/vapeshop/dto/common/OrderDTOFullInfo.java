package project.vapeshop.dto.common;

import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

import java.util.Date;
import java.util.List;

public class OrderDTOFullInfo {
    private Integer id;
    //    change
    private Date date;
//    private Integer idUser;
    //    Enum
    private String status;
    private double price;
    private User user;
    private List<Item> items;

    public OrderDTOFullInfo() {
    }

    public OrderDTOFullInfo(Integer id, Date date, String status, double price, User user, List<Item> items) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.price = price;
        this.user = user;
        this.items = items;
    }

    public OrderDTOFullInfo(Date date, String status, double price, User user, List<Item> items) {
        this.date = date;
        this.status = status;
        this.price = price;
        this.user = user;
        this.items = items;
    }

    public List<Item> getItemList() {
        return items;
    }

    public void setItemList(List<Item> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
