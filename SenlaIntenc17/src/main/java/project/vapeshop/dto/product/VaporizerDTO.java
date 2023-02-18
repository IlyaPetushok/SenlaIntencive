package project.vapeshop.dto.product;

import project.vapeshop.entity.product.Item;

public class VaporizerDTO {
    private Integer id;
    private double resistance;
    //    Enum mb
    private String type;

    private ItemDTOInfoForCatalog itemForVaporizer;

    public VaporizerDTO() {
    }

    public VaporizerDTO(Integer id, double resistance, String type, ItemDTOInfoForCatalog itemForVaporizer) {
        this.id = id;
        this.resistance = resistance;
        this.type = type;
        this.itemForVaporizer = itemForVaporizer;
    }

    public VaporizerDTO(double resistance, String type, ItemDTOInfoForCatalog itemForVaporizer) {
        this.resistance = resistance;
        this.type = type;
        this.itemForVaporizer = itemForVaporizer;
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

    public ItemDTOInfoForCatalog getItemForVaporizer() {
        return itemForVaporizer;
    }

    public void setItemForVaporizer(ItemDTOInfoForCatalog itemForVaporizer) {
        this.itemForVaporizer = itemForVaporizer;
    }

    public void setType(String type) {
        this.type = type;
    }
}
