package project.vapeshop.dto.user;

import lombok.*;
import project.vapeshop.entity.user.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTOForRegistration {
    private Integer id;
    @NonNull
    private String surname;
    @NonNull
    private String name;
    @NonNull
    private String patronymic;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String mail;
    @NonNull
    private Role idRole;

}
