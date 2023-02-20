package project.vapeshop.dto.common;

import lombok.*;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RatingDTOFullInfo {
    private Integer id;
    @NonNull
    private String comment;
    @NonNull
    private Integer quantityStar;
    @NonNull
    private ItemDTOInfoForCatalog item;
    @NonNull
    private UserDTOAfterAuthorization user;

}
