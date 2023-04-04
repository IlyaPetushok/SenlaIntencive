package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IUserDao;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;
import project.vapeshop.exception.NotFoundException;


import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class UserService {
    IUserDao dao;
    ModelMapper modelMapper;

    @Autowired
    public UserService(IUserDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public UserDTOForRegistration showItem(int id) {
        try {
            return modelMapper.map(dao.selectObject(id), UserDTOForRegistration.class);
        } catch (NoResultException exception) {
            throw new NotFoundException(HttpStatus.NOT_FOUND,"user не был найден");
        }
    }

    public List<UserDTOAfterAuthorization> showItems() {
        return dao.selectObjects().stream()
                .map(user -> modelMapper.map(user, UserDTOAfterAuthorization.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDTOForRegistration addItem(UserDTOForRegistration userDTOForRegistration) {
        return modelMapper.map(dao.insertObject(modelMapper.map(userDTOForRegistration, User.class)), UserDTOForRegistration.class);
    }

    @Transactional
    public List<UserDTOForRegistration> addItems(List<UserDTOForRegistration> userDTOForRegistrations) {
        List<User> users = dao.insertObjects(userDTOForRegistrations.stream()
                .map(userDTOForRegistration -> modelMapper.map(userDTOForRegistration, User.class))
                .collect(Collectors.toList()));
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTOForRegistration.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteItem(int id) {
        try {
            return dao.delete(id);
        } catch (NoResultException exception) {
            throw new NotFoundException(HttpStatus.NOT_FOUND,"user не был найден");
        }
    }

    @Transactional
    public UserDTOAfterAuthorization updateItem(UserDTOForRegistration userDTOForRegistration) {
        return modelMapper.map(dao.update(modelMapper.map(userDTOForRegistration, User.class)), UserDTOAfterAuthorization.class);
    }

    public UserDTOAfterAuthorization userFindByLoginWithPassword(UserDTOForAuthorization userDTOForAuthorization){
        try {
            return modelMapper.map(dao.findByLoginAndPassword(modelMapper.map(userDTOForAuthorization, User.class)), UserDTOAfterAuthorization.class);
        } catch (NoResultException exception) {
            throw new NotFoundException(HttpStatus.FORBIDDEN,"Неверный login или password");
        }
    }

    public User userFindByLogin(String login) {
        return dao.findByLogin(login);
    }
}
