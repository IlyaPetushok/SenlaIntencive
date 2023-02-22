package project.vapeshop.dto.product;

import lombok.*;
import project.vapeshop.entity.product.Category;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemDTOFullInfo {
    private Integer id;
    @NonNull
    private String photo;
    @NonNull
    private String name;
    @NonNull
    private Category category;
    @NonNull
    private BigDecimal price;
    @NonNull
    private Integer quantity;

}
