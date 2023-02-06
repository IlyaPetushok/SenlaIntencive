package project.vapeshop.entity.product;

import project.vapeshop.entity.Entity;

public class Liquide implements Entity<Integer> {
    private Integer id;
    private String flavour;
    private int fortress;
//    Enum mb
    private String typeNicotine;
    private int volume;

    public Liquide() {
    }

    public Liquide(String flavour, int fortress, String typeNicotine, int volume) {
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

    public Liquide(Integer id, String flavour, int fortress, String typeNicotine, int volume) {
        this.id = id;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id=id;
    }
}
