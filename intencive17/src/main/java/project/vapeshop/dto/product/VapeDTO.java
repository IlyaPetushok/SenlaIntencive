package project.vapeshop.dto.product;

public class VapeDTO {
    private Integer id;
    private int power;
    private int battery;
    //    Enum
    private String type;

    private ItemDTOInfoForCatalog itemForVape;


    public VapeDTO() {
    }


    public VapeDTO(Integer id, int power, int battery, String type, ItemDTOInfoForCatalog itemForVape) {
        this.id = id;
        this.power = power;
        this.battery = battery;
        this.type = type;
        this.itemForVape = itemForVape;
    }

    public VapeDTO(int power, int battery, String type, ItemDTOInfoForCatalog itemForVape) {
        this.power = power;
        this.battery = battery;
        this.type = type;
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

    public ItemDTOInfoForCatalog getItemForVape() {
        return itemForVape;
    }

    public void setItemForVape(ItemDTOInfoForCatalog itemForVape) {
        this.itemForVape = itemForVape;
    }
}
