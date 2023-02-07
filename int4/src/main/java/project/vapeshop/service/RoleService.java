package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.entity.user.Role;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class RoleService {
    Dao<Role,Integer> dao;
    Mapper<Role, RoleDTO> mapper;

    @Autowired
    public RoleService(Dao<Role,Integer> dao, Mapper<Role, RoleDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public RoleDTO showObject(int id) {
        return mapper.toDTO(dao.getByIdObject(id));
    }

    public List<RoleDTO> showObjects() {
        return mapper.toDTOs(dao.gelAllObjects());
    }

    public boolean addObject(RoleDTO roleDTO) {
        return dao.createObject(mapper.toEntity(roleDTO));
    }

    public boolean addObjects(List<RoleDTO> roleDTOS) {
        return dao.createObjects(mapper.toEntities(roleDTOS));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public RoleDTO updateObject(RoleDTO roleDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(roleDTO)));
    }
}
