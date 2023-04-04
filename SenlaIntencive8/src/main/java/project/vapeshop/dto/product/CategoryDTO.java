package project.vapeshop.dto.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryDTO {
    private Integer id;
    @NonNull
    private String name;
}
