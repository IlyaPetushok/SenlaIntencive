package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IUserDao;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class UserService {
    IUserDao dao;
    ModelMapper modelMapper;

    @Autowired
    public UserService(project.vapeshop.dao.impl.UserDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public UserDTOForRegistration showObject(int id) {
        return modelMapper.map(dao.selectObject(id),UserDTOForRegistration.class);
    }

    public List<UserDTOAfterAuthorization> showObjects() {
        List<User> users=dao.selectObjects();
        return users.stream()
                .map(user -> modelMapper.map(user,UserDTOAfterAuthorization.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDTOForRegistration addObject(UserDTOForRegistration userDTOForRegistration) {
        return modelMapper.map(dao.insertObject(modelMapper.map(userDTOForRegistration,User.class)),UserDTOForRegistration.class);
    }

    @Transactional
    public List<UserDTOForRegistration> addObjects(List<UserDTOForRegistration> userDTOForRegistrations) {
        List<User> users=dao.insertObjects(userDTOForRegistrations.stream()
                .map(userDTOForRegistration -> modelMapper.map(userDTOForRegistration,User.class))
                .collect(Collectors.toList()));
        return users.stream()
                .map(user -> modelMapper.map(user,UserDTOForRegistration.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public UserDTOAfterAuthorization updateObject(UserDTOForRegistration userDTOForRegistration) {
        return modelMapper.map(dao.update(modelMapper.map(userDTOForRegistration,User.class)),UserDTOAfterAuthorization.class);
    }


    public UserDTOAfterAuthorization userFindByLoginWithPassword(UserDTOForAuthorization userDTOForAuthorization){
        return modelMapper.map(dao.findByLoginAndPassword(modelMapper.map(userDTOForAuthorization,User.class)),UserDTOAfterAuthorization.class);
    }

    public User userFindByLogin(String login){
        return dao.findByLogin(login);
    }
}
