package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;



import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    Dao<User,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public UserService(Dao<User,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }


    public UserDTOForRegistration showItem(int id) {
        return modelMapper.map(dao.selectObject(id),UserDTOForRegistration.class);
    }

    public List<UserDTOAfterAuthorization> showItems() {
        return dao.selectObjects().stream()
                .map(user -> modelMapper.map(user,UserDTOAfterAuthorization.class))
                .collect(Collectors.toList());
    }

    public boolean addItem(UserDTOForRegistration userDTOForRegistration) {
        return dao.insertObject(modelMapper.map(userDTOForRegistration,User.class));
    }

    public boolean addItems(List<UserDTOForRegistration> userDTOForRegistrations) {
        return dao.insertObjects(userDTOForRegistrations.stream()
                .map(userDTOForRegistration -> modelMapper.map(userDTOForRegistration,User.class))
                .collect(Collectors.toList()));
    }

    public boolean deleteItem(int id) {
        return dao.delete(id);
    }

    public UserDTOAfterAuthorization updateItem(UserDTOForRegistration userDTOForRegistration) {
        return modelMapper.map(dao.update(modelMapper.map(userDTOForRegistration,User.class)),UserDTOAfterAuthorization.class);
    }
}
