package project.vapeshop.dto.common;

import project.vapeshop.entity.common.StatusOrder;

import java.util.Date;

public class OrderDTOForBasket {
    private Integer id;
    private Date date;

    private StatusOrder status;
    private double price;

    public OrderDTOForBasket() {
    }

    public OrderDTOForBasket(Date date, StatusOrder status, double price) {
        this.date = date;
        this.status = status;
        this.price = price;
    }

    public OrderDTOForBasket(Integer id, Date date, StatusOrder status, double price) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.price = price;
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

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
