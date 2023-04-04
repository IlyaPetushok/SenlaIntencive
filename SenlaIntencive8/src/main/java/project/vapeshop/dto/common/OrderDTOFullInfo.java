package project.vapeshop.dto.common;

import lombok.*;
import project.vapeshop.dto.product.ItemDTOInfoForCatalog;
import project.vapeshop.dto.user.UserDTOForCommon;
import project.vapeshop.entity.common.StatusOrder;
import project.vapeshop.entity.product.Item;
import project.vapeshop.entity.user.User;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDTOFullInfo {
    private Integer id;

    @NonNull
    private Date date;

    @NonNull
    private StatusOrder status;

    @NonNull
    private Double price;

    @NonNull
    private UserDTOForCommon user;

    @NonNull
    private List<ItemDTOInfoForCatalog> items;
}
