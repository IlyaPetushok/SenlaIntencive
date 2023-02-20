package project.vapeshop.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.vapeshop.dao.Dao;
import project.vapeshop.dao.impl.AbstractDao;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.entity.user.Role;


import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional(readOnly = true)
public class RoleService {
    AbstractDao<Role,Integer> dao;
    ModelMapper modelMapper;

    @Autowired
    public RoleService(AbstractDao<Role,Integer> dao, ModelMapper modelMapper) {
        this.dao = dao;
        this.modelMapper = modelMapper;
    }

    public RoleDTO showObject(int id) {
        return modelMapper.map(dao.selectObject(id),RoleDTO.class);
    }

    public List<RoleDTO> showObjects() {
        return dao.selectObjects().stream()
                .map(role -> modelMapper.map(role,RoleDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean addObject(RoleDTO roleDTO) {
        return dao.insertObject(modelMapper.map(roleDTO,Role.class));
    }

    @Transactional
    public boolean addObjects(List<RoleDTO> roleDTOS) {
        return dao.insertObjects(roleDTOS.stream()
                .map(roleDTO -> modelMapper.map(roleDTO,Role.class))
                .collect(Collectors.toList()));
    }

    @Transactional
    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    @Transactional
    public RoleDTO updateObject(RoleDTO roleDTO) {
        return modelMapper.map(dao.update(modelMapper.map(roleDTO,Role.class)),RoleDTO.class);
    }
}
