package project.vapeshop.entity.common;

import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rating")
    private Integer id;
    @Column(name="comment")
    private String comment;
    @Column(name = "quantity_stars")
    private int quantityStar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id_item",referencedColumnName = "id_item")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id_user",referencedColumnName = "id_user")
    private User user;

    public Rating() {
    }


    public Rating(Integer id, String comment, int quantityStar, Item item, User user) {
        this.id = id;
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.item = item;
        this.user = user;
    }

    public Rating(String comment, int quantityStar, Item item, User user) {
        this.comment = comment;
        this.quantityStar = quantityStar;
        this.item = item;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getQuantityStar() {
        return quantityStar;
    }

    public void setQuantityStar(int quantityStar) {
        this.quantityStar = quantityStar;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
