package project.vapeshop.dto.product;

public class ItemDTOInfoForCatalog {
    private Integer id;
    private String photo;
    private String name;

    public ItemDTOInfoForCatalog() {
    }

    public ItemDTOInfoForCatalog(String photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public ItemDTOInfoForCatalog(Integer id, String photo, String name) {
        this.id = id;
        this.photo = photo;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
