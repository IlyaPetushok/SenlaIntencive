package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.entity.user.Privileges;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrivilegesService {
    Dao<Privileges> dao;
    ModelMapper modelMapper;

    @Autowired
    public PrivilegesService(Dao<Privileges> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public PrivilegesDTO showObject(int id) {
        return modelMapper.map(dao.selectObject(id),PrivilegesDTO.class);
    }

    public List<PrivilegesDTO> showObjects() {
        return dao.selectObjects().stream()
                .map(privileges -> modelMapper.map(privileges,PrivilegesDTO.class))
                .collect(Collectors.toList());
    }

    public boolean addObject(PrivilegesDTO privilegesDTO) {
        return dao.insertObject(modelMapper.map(privilegesDTO,Privileges.class));
    }

    public boolean addObjects(List<PrivilegesDTO> privilegesDTOS) {
        return dao.insertObjects(privilegesDTOS.stream()
                .map(privilegesDTO -> modelMapper.map(privilegesDTO,Privileges.class))
                .collect(Collectors.toList()));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public PrivilegesDTO updateObject(PrivilegesDTO privilegesDTO) {
        return modelMapper.map(dao.update(modelMapper.map(privilegesDTO,Privileges.class)),PrivilegesDTO.class);
    }
}
