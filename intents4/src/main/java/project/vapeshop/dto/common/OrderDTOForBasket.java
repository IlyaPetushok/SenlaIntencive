package project.vapeshop.dto.common;

import java.util.Date;

public class OrderDTOForBasket{
    private Integer id;
    //    change
    private Date date;
    //    Enum
    private String status;
    private double price;

    public OrderDTOForBasket(Date date, String status, double price) {
        this.date = date;
        this.status = status;
        this.price = price;
    }

    public OrderDTOForBasket(Integer id, Date date, String status, double price) {
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
}
