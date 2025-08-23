package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateRoleRequestDto;
import com.mera.shine.dto.response.RoleDto;
import com.mera.shine.entity.Role;
import com.mera.shine.mapper.RoleMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the RoleMapper interface.
 */
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toDto(Role entity) {
        if (entity == null) {
            return null;
        }

        return new RoleDto(
                entity.getId(),
                entity.getCode(),
                entity.getLibelle()
        );
    }

    @Override
    public Role toEntity(RoleDto dto) {
        if (dto == null) {
            return null;
        }

        Role role = new Role();
        role.setId(dto.id());
        role.setCode(dto.code());
        role.setLibelle(dto.libelle());

        return role;
    }

    @Override
    public Role createDtoToEntity(CreateRoleRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Role role = new Role();
        role.setCode(createDto.code());
        role.setLibelle(createDto.libelle());

        return role;
    }

    @Override
    public Role updateEntityFromDto(RoleDto dto, Role entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setCode(dto.code());
        entity.setLibelle(dto.libelle());

        return entity;
    }
}