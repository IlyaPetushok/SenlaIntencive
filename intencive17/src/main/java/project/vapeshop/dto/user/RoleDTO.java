package project.vapeshop.dto.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Integer id;
    private String name;

    public RoleDTO(Integer id) {
        this.id = id;
    }

    public RoleDTO(String name) {
        this.name = name;
    }
}
