package project.vapeshop.dto.product;

public class VapeDTO {
    private Integer id;
    private int power;
    private int battery;
    //    Enum
    private String type;

    public VapeDTO() {
    }

    public VapeDTO(int power, int battery, String type) {
        this.power = power;
        this.battery = battery;
        this.type = type;
    }

    public VapeDTO(Integer id, int power, int battery, String type) {
        this.id = id;
        this.power = power;
        this.battery = battery;
        this.type = type;
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
