package project.vapeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.dao.Dao;
import project.vapeshop.dto.product.CategoryDTO;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class PrivilegesService {
    Dao<Privileges> dao;
    Mapper<Privileges, PrivilegesDTO> mapper;

    @Autowired
    public PrivilegesService(Dao<Privileges> dao, Mapper<Privileges, PrivilegesDTO> mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    public PrivilegesDTO showObject(int id) {
        return mapper.toDTO(dao.selectObject(id));
    }

    public List<PrivilegesDTO> showObjects() {
        return mapper.toDTOs(dao.selectObjects());
    }

    public boolean addObject(PrivilegesDTO privilegesDTO) {
        return dao.insertObject(mapper.toEntity(privilegesDTO));
    }

    public boolean addObjects(List<PrivilegesDTO> privilegesDTOS) {
        return dao.insertObjects(mapper.toEntities(privilegesDTOS));
    }

    public boolean deleteObject(int id) {
        return dao.delete(id);
    }

    public PrivilegesDTO updateObject(PrivilegesDTO privilegesDTO) {
        return mapper.toDTO(dao.update(mapper.toEntity(privilegesDTO)));
    }
}
