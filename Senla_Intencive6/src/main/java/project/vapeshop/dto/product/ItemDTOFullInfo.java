package project.vapeshop.dto.product;

import project.vapeshop.entity.product.Category;

import java.math.BigDecimal;

public class ItemDTOFullInfo {
    private Integer id;
    private String photo;
    private String name;
    private Category category;
//    private Integer idCategory;
    private BigDecimal price;
    private int quantity;

    public ItemDTOFullInfo() {
    }

    public ItemDTOFullInfo(Integer id, String photo, String name, Category category, BigDecimal price, int quantity) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public ItemDTOFullInfo(String photo, String name, Category category, BigDecimal price, int quantity) {
        this.photo = photo;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    //    public ItemDTOFullInfo(String photo, String name, Integer idCategory, BigDecimal price, int quantity) {
//        this.photo = photo;
//        this.name = name;
//        this.idCategory = idCategory;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public ItemDTOFullInfo(int id, String photo, String name, Integer idCategory, BigDecimal price, int quantity) {
//        this.id = id;
//        this.photo = photo;
//        this.name = name;
//        this.idCategory = idCategory;
//        this.price = price;
//        this.quantity = quantity;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //    public Integer getIdCategory() {
//        return idCategory;
//    }
//
//    public void setIdCategory(Integer nameCategory) {
//        this.idCategory = nameCategory;
//    }

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
}
