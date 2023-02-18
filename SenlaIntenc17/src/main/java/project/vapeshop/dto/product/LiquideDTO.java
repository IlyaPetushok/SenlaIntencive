package project.vapeshop.dto.product;

import project.vapeshop.entity.product.Item;

public class LiquideDTO {
    private Integer id;
    private ItemDTOInfoForCatalog item;
    private String flavour;
    private int fortress;
    //    Enum mb
    private String typeNicotine;
    private int volume;

    public LiquideDTO() {
    }

    public LiquideDTO(Integer id) {
        this.id = id;
    }

    public LiquideDTO(Integer id, ItemDTOInfoForCatalog item, String flavour, int fortress, String typeNicotine, int volume) {
        this.id = id;
        this.item = item;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }



    public LiquideDTO(ItemDTOInfoForCatalog item, String flavour, int fortress, String typeNicotine, int volume) {
        this.item = item;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

    public LiquideDTO(Integer id, String flavour, int fortress, String typeNicotine, int volume) {
        this.id = id;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public int getFortress() {
        return fortress;
    }

    public void setFortress(int fortress) {
        this.fortress = fortress;
    }

    public String getTypeNicotine() {
        return typeNicotine;
    }

    public void setTypeNicotine(String typeNicotine) {
        this.typeNicotine = typeNicotine;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public ItemDTOInfoForCatalog getItemForLiquide() {
        return item;
    }

    public void setItemForLiquide(ItemDTOInfoForCatalog item) {
        this.item = item;
    }
}
