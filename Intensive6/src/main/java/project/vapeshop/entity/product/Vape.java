package project.vapeshop.entity.product;

import project.vapeshop.entity.EntityId;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="Vape")
public class Vape implements EntityId<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vape")
    private Integer id;
    @Column(name="power_vape")
    private int power;
    @Column(name = "battery")
    private int battery;
//    Enum
    @Column(name = "type_vape")
    private String type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vape_id",referencedColumnName = "id_item")
    private Item itemForVape;

    public Vape() {
    }

    public Vape(int power, int battery, String type, Item itemForVape) {
        this.power = power;
        this.battery = battery;
        this.type = type;
        this.itemForVape = itemForVape;
    }

    public Vape(Integer id, int power, int battery, String type, Item itemForVape) {
        this.id = id;
        this.power = power;
        this.battery = battery;
        this.type = type;
        this.itemForVape = itemForVape;
    }

    public Item getItemForVape() {
        return itemForVape;
    }

    public void setItemForVape(Item itemForVape) {
        this.itemForVape = itemForVape;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
