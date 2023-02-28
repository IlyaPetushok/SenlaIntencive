package project.vapeshop.entity.common;

import lombok.*;
import project.vapeshop.entity.EntityId;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Rating implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rating")
    private Integer id;

    @NonNull
    @Column(name="comment")
    private String comment;

    @NonNull
    @Column(name = "quantity_stars")
    private Integer quantityStar;


    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id_item",referencedColumnName = "id_item")
    private Item item;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rating_id_user",referencedColumnName = "id_user")
    private User user;
}
