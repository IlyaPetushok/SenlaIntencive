package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.impl.UserDao;
import project.vapeshop.dao.impl.UserInt;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class UserService {
    UserInt dao;
    ModelMapper modelMapper;

    @Autowired
    public UserService(UserDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public UserDTOForRegistration showObject(int id) {
        return modelMapper.map(dao.selectObject(id),UserDTOForRegistration.class);
    }

    public List<UserDTOAfterAuthorization> showObjects() {
        return dao.selectObjects().stream()
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



//    @Transactional
    public UserDTOForRegistration userInput(UserDTOForRegistration userDTOForRegistration){
        return modelMapper.map(dao.findByLoginAndPassword(modelMapper.map(userDTOForRegistration,User.class)),UserDTOForRegistration.class);
    }

    public User userFindByLogin(String login){
        return dao.findByLogin(login);
    }

//    public UserDTOAfterAuthorization userFindByLogin(UserDTOForRegistration userDTOForRegistration){
//        return modelMapper.map(dao.findByLogin(modelMapper.map(userDTOForRegistration,User.class)),UserDTOAfterAuthorization.class);
//    }
}
