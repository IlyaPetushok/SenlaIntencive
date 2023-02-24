package project.vapeshop.entity.common;

import lombok.*;
import org.hibernate.Hibernate;
import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@NamedEntityGraphs(
        {
                @NamedEntityGraph(
                        name = "order_items",
                        attributeNodes = {
                            @NamedAttributeNode("items")
                        }
                )
        }
)


@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Order implements EntityId<Integer> {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name = "data_order")
    private Date date;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id_user", referencedColumnName = "id_user")
    @ToString.Exclude
    private User user;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_order")
    private StatusOrder status;

    @NonNull
    @Column(name = "total_price")
    private Double price;

    @NonNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "ot_id_order"),
            inverseJoinColumns = @JoinColumn(name = "ot_id_item"))
    @ToString.Exclude
    private List<Item> items;

}
