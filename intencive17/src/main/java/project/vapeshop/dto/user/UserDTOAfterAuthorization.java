package project.vapeshop.dto.user;

import lombok.*;
import project.vapeshop.entity.user.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOAfterAuthorization {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String mail;
    private RoleDTO role;

    public UserDTOAfterAuthorization(int id) {
        this.id = id;
    }

    public UserDTOAfterAuthorization(String surname, String name, String patronymic, String mail,RoleDTO role) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.mail = mail;
        this.role = role;
    }
}
