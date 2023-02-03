package project.vapeshop.dto.product;

public class LiquideDTO {
    private Integer id;
    private String flavour;
    private int fortress;
    //    Enum mb
    private String typeNicotine;
    private int volume;

    public LiquideDTO(String flavour, int fortress, String typeNicotine, int volume) {
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
}
