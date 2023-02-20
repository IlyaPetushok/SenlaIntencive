package project.vapeshop.entity.product;


import project.vapeshop.entity.EntityId;

import javax.persistence.*;

@Entity
@Table(name="vaporizer")
public class Vaporizer implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaporizer")
    private Integer id;

    @Column(name = "resistance")
    private double resistance;

    @Column(name = "type_vaporizer")
    private String type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaporizer_id_item",referencedColumnName = "id_item")
    private Item itemForVaporizer;

    public Vaporizer() {
    }

    public Vaporizer(Integer id, double resistance, String type, Item itemForVaporizer) {
        this.id = id;
        this.resistance = resistance;
        this.type = type;
        this.itemForVaporizer = itemForVaporizer;
    }

    public Vaporizer(double resistance, String type, Item itemForVaporizer) {
        this.resistance = resistance;
        this.type = type;
        this.itemForVaporizer = itemForVaporizer;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Item getItemForVaporizer() {
        return itemForVaporizer;
    }

    public void setItemForVaporizer(Item itemForVaporizer) {
        this.itemForVaporizer = itemForVaporizer;
    }
}
