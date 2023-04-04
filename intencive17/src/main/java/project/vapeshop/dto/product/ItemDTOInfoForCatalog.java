package project.vapeshop.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTOInfoForCatalog {
    private Integer id;
    private String photo;
    private String name;

    public ItemDTOInfoForCatalog(Integer id) {
        this.id = id;
    }

    public ItemDTOInfoForCatalog(String photo, String name) {
        this.photo = photo;
        this.name = name;
    }

}
