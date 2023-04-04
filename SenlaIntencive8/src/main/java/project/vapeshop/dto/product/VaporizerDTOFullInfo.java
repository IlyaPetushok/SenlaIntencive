package project.vapeshop.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class VaporizerDTOFullInfo {
    private Integer id;
    @NonNull
    private Double resistance;
    @NonNull
    private String type;
}
