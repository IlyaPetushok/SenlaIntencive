package project.vapeshop.service.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.IUserDao;
import project.vapeshop.dto.user.UserDTOAfterAuthorization;
import project.vapeshop.dto.user.UserDTOFilter;
import project.vapeshop.dto.user.UserDTOForAuthorization;
import project.vapeshop.dto.user.UserDTOForRegistration;
import project.vapeshop.entity.user.User;
import project.vapeshop.entity.user.User_;
import project.vapeshop.exception.NotFoundException;
import project.vapeshop.exception.UnAuthorizationException;
import project.vapeshop.predicate.CustomPredicate;
import project.vapeshop.predicate.TypeFunctionForSql;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class UserService {
    IUserDao dao;
    ModelMapper modelMapper;
    private static final Logger logg = LogManager.getLogger(UserService.class.getName());

    @Autowired
    public UserService(IUserDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public UserDTOForRegistration showObject(int id) {
        User user;
        try {
            user = dao.selectObject(id);
        } catch (NoResultException exception) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "user dont found");
        }
        return modelMapper.map(user, UserDTOForRegistration.class);
    }

    public List<UserDTOAfterAuthorization> showObjects() {
        List<User> users = dao.selectObjects();
        if (users.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "list users is empty");
        }
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTOAfterAuthorization.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDTOForRegistration addObject(UserDTOForRegistration userDTOForRegistration) {

        logg.error("hi");
        logg.info("start");
        logg.debug("This is a debug message");
        logg.info("This is an info message");
        logg.warn("This is a warn message");
        logg.error("This is an error message");
        return modelMapper.map(dao.insertObject(modelMapper.map(userDTOForRegistration, User.class)), UserDTOForRegistration.class);
    }

    @Transactional
    public List<UserDTOForRegistration> addObjects(List<UserDTOForRegistration> userDTOForRegistrations) {
        List<User> users = dao.insertObjects(userDTOForRegistrations.stream()
                .map(userDTOForRegistration -> modelMapper.map(userDTOForRegistration, User.class))
                .collect(Collectors.toList()));
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTOForRegistration.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public boolean deleteObject(int id) {
        try {
            return dao.delete(id);
        } catch (NoResultException exception) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "user dont found");
        }
    }

    @Transactional
    public UserDTOAfterAuthorization updateObject(UserDTOForRegistration userDTOForRegistration) {
        return modelMapper.map(dao.update(modelMapper.map(userDTOForRegistration, User.class)), UserDTOAfterAuthorization.class);
    }


    public UserDTOAfterAuthorization userFindByLoginWithPassword(UserDTOForAuthorization userDTOForAuthorization) {
        try {
            return modelMapper.map(dao.findByLoginAndPassword(modelMapper.map(userDTOForAuthorization, User.class)), UserDTOAfterAuthorization.class);
        } catch (NoResultException exception) {
            throw new UnAuthorizationException(HttpStatus.FORBIDDEN, "Check login or password");
        }
    }

    public User userFindByLogin(String login) {
        try {
            return dao.findByLogin(login);
        } catch (NoResultException resultException) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "authorization please");
        }
    }

    public List<UserDTOAfterAuthorization> userFindByFilter(UserDTOFilter userDTOFilter) {
        List<CustomPredicate> predicates = new ArrayList<>();
        if (userDTOFilter.getName() != null) {
            predicates.add(new CustomPredicate(userDTOFilter.getName(), User_.NAME, TypeFunctionForSql.EQUAL));
        }
        if (userDTOFilter.getPatronymic() != null) {
            predicates.add(new CustomPredicate(userDTOFilter.getPatronymic(), User_.PATRONYMIC, TypeFunctionForSql.EQUAL));
        }
        if (userDTOFilter.getSurname() != null) {
            predicates.add(new CustomPredicate(userDTOFilter.getSurname(), User_.SURNAME, TypeFunctionForSql.EQUAL));
        }
        if (userDTOFilter.getLogin() != null) {
            predicates.add(new CustomPredicate(userDTOFilter.getLogin(), User_.LOGIN, TypeFunctionForSql.EQUAL));
        }
        if (userDTOFilter.getPassword() != null) {
            predicates.add(new CustomPredicate(userDTOFilter.getPassword(), User_.PASSWORD, TypeFunctionForSql.EQUAL));
        }
        if (userDTOFilter.getMail() != null) {
            predicates.add(new CustomPredicate(userDTOFilter.getMail(), User_.MAIL, TypeFunctionForSql.EQUAL));
        }
        Pageable pageable = PageRequest.of(userDTOFilter.getPage(), userDTOFilter.getSize(), Sort.by(Sort.Direction.ASC,userDTOFilter.getSort()));
        Page<User> users = dao.selectObjectsByFilter(predicates,pageable);
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTOAfterAuthorization.class))
                .collect(Collectors.toList());
    }
}
