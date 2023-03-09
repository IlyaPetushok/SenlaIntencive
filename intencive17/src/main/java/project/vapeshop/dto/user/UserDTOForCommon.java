package project.vapeshop.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOForCommon {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;

    public UserDTOForCommon(Integer id) {
        this.id = id;
    }

    public UserDTOForCommon(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }
}
