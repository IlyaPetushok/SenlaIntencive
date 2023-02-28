package project.vapeshop.entity.product;


import lombok.*;
import project.vapeshop.entity.EntityId;

import javax.persistence.*;

@Entity
@Table(name="vaporizer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Vaporizer implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaporizer")
    private Integer id;

    @NonNull
    @Column(name = "resistance")
    private Double resistance;

    @NonNull
    @Column(name = "type_vaporizer")
    private String type;

    @ToString.Exclude
    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaporizer_id_item",referencedColumnName = "id_item")
    private Item itemForVaporizer;

}
