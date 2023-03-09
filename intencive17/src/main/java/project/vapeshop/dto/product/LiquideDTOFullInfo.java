package project.vapeshop.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LiquideDTOFullInfo {
    private Integer id;
    private ItemDTOInfoForCatalog item;
    private String flavour;
    private int fortress;
    private String typeNicotine;
    private int volume;

    public LiquideDTOFullInfo(Integer id) {
        this.id = id;
    }

    public LiquideDTOFullInfo(ItemDTOInfoForCatalog item, String flavour, int fortress, String typeNicotine, int volume) {
        this.item = item;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

    public LiquideDTOFullInfo(Integer id, String flavour, int fortress, String typeNicotine, int volume) {
        this.id = id;
        this.flavour = flavour;
        this.fortress = fortress;
        this.typeNicotine = typeNicotine;
        this.volume = volume;
    }

}
