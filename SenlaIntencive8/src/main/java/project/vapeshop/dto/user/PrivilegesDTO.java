package project.vapeshop.dto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PrivilegesDTO {
    private Integer id;
    @NonNull
    private String name;
}
