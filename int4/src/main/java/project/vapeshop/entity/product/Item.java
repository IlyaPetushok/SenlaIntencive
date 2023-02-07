package project.vapeshop.entity.product;

import project.vapeshop.entity.Entity;

import java.math.BigDecimal;

public class Item implements Entity<Integer> {
    private Integer id;
    private String photo;
    private String name;
    private Integer idCategory;
    private BigDecimal price;
    private int quantity;

    public Item() {
    }

    public Item(String photo, String name, Integer idCategory, BigDecimal price, int quantity) {
        this.photo = photo;
        this.name = name;
        this.idCategory = idCategory;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(Integer id, String photo, String name, Integer idCategory, BigDecimal price, int quantity) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.idCategory = idCategory;
        this.price = price;
        this.quantity = quantity;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }
}
