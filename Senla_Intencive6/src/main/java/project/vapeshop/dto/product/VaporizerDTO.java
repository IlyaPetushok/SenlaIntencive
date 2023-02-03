package project.vapeshop.dto.product;

public class VaporizerDTO {
    private Integer id;
    private double resistance;
    //    Enum mb
    private String type;

    public VaporizerDTO() {
    }

    public VaporizerDTO(double resistance, String type) {
        this.resistance = resistance;
        this.type = type;
    }

    public VaporizerDTO(Integer id, double resistance, String type) {
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
