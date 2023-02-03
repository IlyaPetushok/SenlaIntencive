package project.vapeshop.mapper.impl.user;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.PrivilegesDTO;
import project.vapeshop.entity.user.Privileges;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class PrivilegesMapper implements Mapper<Privileges, PrivilegesDTO> {
    @Override
    public PrivilegesDTO toDTO(Privileges privileges) {
        return new PrivilegesDTO(privileges.getId(), privileges.getName());
    }

    @Override
    public List<PrivilegesDTO> toDTOs(List<Privileges> privilegesEntities) {
        return privilegesEntities.stream()
                .map(privileges -> new PrivilegesDTO(privileges.getId(), privileges.getName()))
                .toList();
    }

    @Override
    public Privileges toEntity(PrivilegesDTO privilegesDTO) {
        return new Privileges(privilegesDTO.getId(),privilegesDTO.getName());
    }

    @Override
    public List<Privileges> toEntities(List<PrivilegesDTO> privilegesDTOs) {
        return privilegesDTOs.stream()
                .map(privilegesDTO -> new Privileges(privilegesDTO.getId(),privilegesDTO.getName()))
                .toList();
    }
}
