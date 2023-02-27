package project.vapeshop.dto.user;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTOForRating {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String mail;

    public UserDTOForRating(Integer id) {
        this.id = id;
    }

    public UserDTOForRating(String surname, String name, String patronymic, String mail) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.mail = mail;
    }
}
