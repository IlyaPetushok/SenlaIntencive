package project.vapeshop.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class LiquideDTOFullInfo {
    private Integer id;
    @NonNull
    private String flavour;
    @NonNull
    private Integer fortress;
    @NonNull
    private String typeNicotine;
    @NonNull
    private Integer volume;

    public LiquideDTOFullInfo(Integer id) {
        this.id = id;
    }
<<<<<<<< HEAD:intencive17/src/main/java/project/vapeshop/dto/product/LiquideDTO.java
========

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

>>>>>>>> origin/homework-8-security:SenlaIntencive8/src/main/java/project/vapeshop/dto/product/LiquideDTOFullInfo.java
}

