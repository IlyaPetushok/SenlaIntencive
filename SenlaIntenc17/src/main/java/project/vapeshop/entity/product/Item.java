package project.vapeshop.entity.product;

import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.common.Order;
import project.vapeshop.entity.common.Rating;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "entity-item-graph-liquide",
                attributeNodes = {
                        @NamedAttributeNode("liquide"),
//                        @NamedAttributeNode("vape"),
                }
        ),
        @NamedEntityGraph(
                name = "entity-item-graph-category",
                attributeNodes = {
                        @NamedAttributeNode("category")
                }
        )})

@Entity
@Table(name = "item")
public class Item implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer id;
    @Column(name = "photo")
    private String photo;
    @Column(name = "name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category category;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Order> order;

    @OneToOne(mappedBy = "itemForLiquide",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Liquide liquide;

    @OneToOne(mappedBy = "itemForVaporizer", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Vaporizer vaporizer;


    @OneToOne(mappedBy = "itemForVape", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Vape vape;


    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String photo, String name) {
        this.id = id;
        this.photo = photo;
        this.name = name;
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