package project.vapeshop.entity.common;

import project.vapeshop.entity.Entity;

import java.util.Date;

public class Order implements Entity<Integer> {
    private Integer id;
//    change
    private Date date;
    private Integer idUser;
//    Enum
    private String status;
    private double price;

    public Order(Date date, Integer idUser, String status, double price) {
        this.date = date;
        this.idUser = idUser;
        this.status = status;
        this.price = price;
    }

    public Order(Integer id, Date date, Integer idUser, String status, double price) {
        this.id = id;
        this.date = date;
        this.idUser = idUser;
        this.status = status;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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
