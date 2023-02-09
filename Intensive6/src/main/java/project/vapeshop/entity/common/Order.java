package project.vapeshop.entity.common;

import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order implements EntityId<Integer> {
    @Id
    @Column(name="id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    change
    @Column(name="data_order")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id_user",referencedColumnName = "id_user")
    private User user;
//    Enum
    @Column(name="status_order")
    private String status;

    @Column(name="total_price")
    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_item",
    joinColumns = @JoinColumn(name = "ot_id_order"),
    inverseJoinColumns = @JoinColumn(name="ot_id_item"))
    private List<Item> items;

    public Order() {
    }

    public Order(Integer id, Date date, User user, String status, double price) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.status = status;
        this.price = price;
    }

    public Order(Date date, User user, String status, double price) {
        this.date = date;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
