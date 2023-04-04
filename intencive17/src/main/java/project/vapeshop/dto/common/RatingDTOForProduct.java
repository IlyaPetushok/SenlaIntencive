package project.vapeshop.dto.common;

import lombok.*;
import project.vapeshop.dto.user.UserDTOForCommon;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RatingDTOForProduct {
    private Integer id;
    @NonNull
    private String comment;
    @NonNull
    private Integer quantityStar;
    @NonNull
    private UserDTOForCommon user;
}
