package project.vapeshop.mapper.impl.user;

import org.springframework.stereotype.Component;
import project.vapeshop.dto.user.RoleDTO;
import project.vapeshop.entity.user.Role;
import project.vapeshop.mapper.Mapper;

import java.util.List;

@Component
public class RoleMapper implements Mapper<Role, RoleDTO> {
    @Override
    public RoleDTO toDTO(Role role) {
        return new RoleDTO(role.getId(), role.getName());
    }

    @Override
    public List<RoleDTO> toDTOs(List<Role> roleEntities) {
        return roleEntities.stream()
                .map(role -> new RoleDTO(role.getId(), role.getName()))
                .toList();
    }

    @Override
    public Role toEntity(RoleDTO roleDTO) {
        return new Role(roleDTO.getId(),roleDTO.getName());
    }

    @Override
    public List<Role> toEntities(List<RoleDTO> roleDTOs) {
        return roleDTOs.stream()
                .map(roleDTO -> new Role(roleDTO.getId(),roleDTO.getName()))
                .toList();
    }
}
