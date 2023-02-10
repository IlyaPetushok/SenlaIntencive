package project.vapeshop.dto.product;

import project.vapeshop.entity.product.Item;

public class VaporizerDTO {
    private Integer id;
    private double resistance;
    //    Enum mb
    private String type;

    private Item item;

    public VaporizerDTO() {
    }

    public VaporizerDTO(Integer id, double resistance, String type, Item item) {
        this.id = id;
        this.resistance = resistance;
        this.type = type;
        this.item = item;
    }

    public VaporizerDTO(double resistance, String type, Item item) {
        this.resistance = resistance;
        this.type = type;
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setType(String type) {
        this.type = type;
    }
}
