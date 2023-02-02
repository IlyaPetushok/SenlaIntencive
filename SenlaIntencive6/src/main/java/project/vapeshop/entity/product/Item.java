package project.vapeshop.entity.product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer id;
    @Column(name="photo")
    private String photo;
    @Column(name = "name")
    private String name;
//    @Column(name="id_category")

    @ManyToOne()
    @JoinColumn(name = "id_category",referencedColumnName = "id_category")
    private Category category;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="quantity")
    private int quantity;

    public Item() {
    }

    public Item(Integer id, String photo, String name, Category category, BigDecimal price, int quantity) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(String photo, String name, Category category, BigDecimal price, int quantity) {
        this.photo = photo;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    //    public Item(String photo, String name, Integer idCategory, BigDecimal price, int quantity) {
//        this.photo = photo;
//        this.name = name;
//        this.idCategory = idCategory;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public Item(Integer id, String photo, String name, Integer idCategory, BigDecimal price, int quantity) {
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
//    public void setIdCategory(Integer idCategory) {
//        this.idCategory = idCategory;
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
