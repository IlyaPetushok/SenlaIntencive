package project.vapeshop.entity.product;

import project.vapeshop.entity.EntityGetSetId;

public class Vaporizer implements EntityGetSetId {
    private Integer id;
    private double resistance;
//    Enum mb
    private String type;

    public Vaporizer() {
    }

    public Vaporizer(double resistance, String type) {
        this.resistance = resistance;
        this.type = type;
    }

    public Vaporizer(Integer id, double resistance, String type) {
        this.id = id;
        this.resistance = resistance;
        this.type = type;
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

    public void setType(String type) {
        this.type = type;
    }
}
