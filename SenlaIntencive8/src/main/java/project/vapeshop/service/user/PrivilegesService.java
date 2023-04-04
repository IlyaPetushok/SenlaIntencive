package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.IPrivilegeDao;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.exception.NotFoundException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class PrivilegesService {
    IPrivilegeDao dao;
    ModelMapper modelMapper;

    @Autowired
    public PrivilegesService(IPrivilegeDao dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public PrivilegesDTO showObject(int id) {
        try {
            return modelMapper.map(dao.selectObject(id), PrivilegesDTO.class);
        } catch (NoResultException noResultException) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "privilege dont found");
        }
    }

    public List<PrivilegesDTO> showObjects() {
        List<Privileges> privileges=dao.selectObjects();
        if(privileges.isEmpty()){
            throw new NotFoundException(HttpStatus.NOT_FOUND, "privilege list is empty");
        }
        return privileges.stream()
                .map(p -> modelMapper.map(p, PrivilegesDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public PrivilegesDTO addObject(PrivilegesDTO privilegesDTO) {
        return modelMapper.map(dao.insertObject(modelMapper.map(privilegesDTO, Privileges.class)), PrivilegesDTO.class);
    }

    @Transactional
    public List<PrivilegesDTO> addObjects(List<PrivilegesDTO> privilegesDTOS) {
        List<Privileges> privileges = dao.insertObjects(privilegesDTOS.stream()
                .map(privilegesDTO -> modelMapper.map(privilegesDTO, Privileges.class))
                .collect(Collectors.toList()));
        return privileges.stream()
                .map(priv -> modelMapper.map(priv, PrivilegesDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean deleteObject(int id) {
        try {
            return dao.delete(id);
        } catch (NoResultException noResultException) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, "privilege dont found");
        }
    }

    @Transactional
    public PrivilegesDTO updateObject(PrivilegesDTO privilegesDTO) {
        return modelMapper.map(dao.update(modelMapper.map(privilegesDTO, Privileges.class)), PrivilegesDTO.class);
    }
}
