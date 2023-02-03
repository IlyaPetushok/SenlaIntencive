package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.entity.user.Role;


import java.util.List;

@Component
public class RoleService {
    Dao<Role> dao;
    ModelMapper modelMapper;

    @Autowired
    public RoleService(Dao<Role> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public RoleDTO showObject(int id) {
        return modelMapper.map(dao.selectObject(id),RoleDTO.class);
    }

    public List<RoleDTO> showObjects() {
        return dao.selectObjects().stream()
                .map(role -> modelMapper.map(role,RoleDTO.class))
                .toList();
    }

    public boolean addObject(RoleDTO roleDTO) {
        return dao.insertObject(modelMapper.map(roleDTO,Role.class));
    }

    public boolean addObjects(List<RoleDTO> roleDTOS) {
        return dao.insertObjects(roleDTOS.stream()
                .map(roleDTO -> modelMapper.map(roleDTO,Role.class))
                .toList());
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public RoleDTO updateObject(RoleDTO roleDTO) {
        return modelMapper.map(dao.update(modelMapper.map(roleDTO,Role.class)),RoleDTO.class);
    }
}
