package project.vapeshop.dto.user;

import lombok.*;

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
    private Integer idRole;


    public UserDTOAfterAuthorization(int id) {
        this.id = id;
    }

    public UserDTOAfterAuthorization(String surname, String name, String patronymic, String mail, Integer idRole) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.mail = mail;
        this.idRole = idRole;
    }
}
