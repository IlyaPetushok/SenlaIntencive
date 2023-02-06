package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;
import project.vapeshop.mapper.impl.user.UserAuthorizationMapper;
import project.vapeshop.mapper.impl.user.UserRegistrationMapper;

import java.util.List;

@Component
public class UserService {
    Dao<User,Integer> dao;
    UserAuthorizationMapper authorizationMapper;
    UserRegistrationMapper registrationMapper;


    @Autowired
    public UserService(Dao<User,Integer> dao, UserAuthorizationMapper authorizationMapper, UserRegistrationMapper registrationMapper) {
        this.dao = dao;
        this.authorizationMapper = authorizationMapper;
        this.registrationMapper = registrationMapper;
    }

    public UserDTOForRegistration showItem(int id) {
        return registrationMapper.toDTO(dao.getByIdObject(id));
    }

    public List<UserDTOAfterAuthorization> showItems() {
        return authorizationMapper.toDTOs(dao.gelAllObjects());
    }

    public boolean addItem(UserDTOForRegistration userDTOForRegistration) {
        return dao.createObject(registrationMapper.toEntity(userDTOForRegistration));
    }

    public boolean addItems(List<UserDTOForRegistration> userDTOForRegistrations) {
        return dao.createObjects(registrationMapper.toEntities(userDTOForRegistrations));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public UserDTOAfterAuthorization updateItem(UserDTOForRegistration userDTOForRegistration) {
        return authorizationMapper.toDTO(dao.update(registrationMapper.toEntity(userDTOForRegistration)));
    }
}
