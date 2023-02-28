package project.vapeshop.entity.product;

import lombok.*;
import org.hibernate.annotations.Cascade;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category category;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "quantity")
    private int quantity;

    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private List<Rating> ratings;

    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Order> order;

    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne(mappedBy = "itemForLiquide",fetch = FetchType.LAZY)
    private Liquide liquide;

    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne(mappedBy = "itemForVaporizer", fetch = FetchType.LAZY)
    private Vaporizer vaporizer;

    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToOne(mappedBy = "itemForVape", fetch = FetchType.LAZY)
    private Vape vape;


    public Item(Integer id) {
        this.id = id;
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

}
