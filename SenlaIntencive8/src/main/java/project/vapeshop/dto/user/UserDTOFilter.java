package project.vapeshop.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.vapeshop.dto.FilterRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOFilter extends FilterRequest {
    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private String password;
    private String mail;
}
