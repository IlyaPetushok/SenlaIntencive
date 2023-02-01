package project.vapeshop.mapper.impl.user;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class UserRegistrationMapper implements Mapper<User, UserDTOForRegistration> {
    @Override
    public UserDTOForRegistration toDTO(User user) {
        return null;
    }

    @Override
    public List<UserDTOForRegistration> toDTOs(List<User> userEntities) {
        return null;
    }

    @Override
    public User toEntity(UserDTOForRegistration userDTOForRegistration) {
        return new User(userDTOForRegistration.getId(), userDTOForRegistration.getSurname(), userDTOForRegistration.getName(), userDTOForRegistration.getPatronymic(), userDTOForRegistration.getLogin(), userDTOForRegistration.getPassword(), userDTOForRegistration.getMail(), userDTOForRegistration.getIdRole());
    }

    @Override
    public List<User> toEntities(List<UserDTOForRegistration> userDTOForRegistrations) {
        return userDTOForRegistrations.stream()
                .map(userDTOForRegistration->new User(userDTOForRegistration.getId(), userDTOForRegistration.getSurname(), userDTOForRegistration.getName(), userDTOForRegistration.getPatronymic(), userDTOForRegistration.getLogin(), userDTOForRegistration.getPassword(), userDTOForRegistration.getMail(), userDTOForRegistration.getIdRole()))
                .toList();
    }
}
