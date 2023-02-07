package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class PrivilegesService {
    Dao<Privileges,Integer> dao;
    Mapper<Privileges, PrivilegesDTO> mapper;

    @Autowired
    public PrivilegesService(Dao<Privileges,Integer> dao, Mapper<Privileges, PrivilegesDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public PrivilegesDTO showObject(int id) {
        return mapper.toDTO(dao.getByIdObject(id));
    }

    public List<PrivilegesDTO> showObjects() {
        return mapper.toDTOs(dao.gelAllObjects());
    }

    public boolean addObject(PrivilegesDTO privilegesDTO) {
        return dao.createObject(mapper.toEntity(privilegesDTO));
    }

    public boolean addObjects(List<PrivilegesDTO> privilegesDTOS) {
        return dao.createObjects(mapper.toEntities(privilegesDTOS));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public PrivilegesDTO updateObject(PrivilegesDTO privilegesDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(privilegesDTO)));
    }
}
