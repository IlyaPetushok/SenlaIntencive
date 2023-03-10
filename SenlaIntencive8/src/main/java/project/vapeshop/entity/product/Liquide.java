package project.vapeshop.entity.product;

import lombok.*;
import project.vapeshop.entity.EntityId;

import javax.persistence.*;

@NamedEntityGraph(
        name = "liquide-with-item",
        attributeNodes = {
                @NamedAttributeNode("itemForLiquide"),
        }
)
@Entity
@Table(name = "liquide")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Liquide implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_liquide")
    private Integer id;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liquide_id_item",referencedColumnName = "id_item")
    private Item itemForLiquide;

    @NonNull
    @Column(name = "flavour")
    private String flavour;

    @NonNull
    @Column(name = "fortress")
    private Integer fortress;

    @NonNull
    @Column(name="type_nicotine")
    private String typeNicotine;

    @NonNull
    @Column(name="volume")
    private Integer volume;
}