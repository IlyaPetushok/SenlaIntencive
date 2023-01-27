package project.vapeshop.mapper.impl.user;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.entity.user.User;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class UserAuthorizationMapper implements Mapper<User, UserDTOAfterAuthorization> {
    @Override
    public UserDTOAfterAuthorization toDTO(User user) {
        return new UserDTOAfterAuthorization(user.getId(), user.getSurname(), user.getName(), user.getPatronymic(), user.getMail(), user.getIdRole());
    }

    @Override
    public List<UserDTOAfterAuthorization> toDTOs(List<User> userEntities) {
        return userEntities.stream()
                .map(user -> new UserDTOAfterAuthorization(user.getId(), user.getSurname(), user.getName(), user.getPatronymic(), user.getMail(), user.getIdRole()))
                .toList();
    }

    @Override
    public User toEntity(UserDTOAfterAuthorization userDTOAfterAuthorization) {
        return null;
    }

    @Override
    public List<User> toEntities(List<UserDTOAfterAuthorization> userDTOAfterAuthorizations) {
        return null;
    }
}
