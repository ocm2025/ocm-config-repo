package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateGroupsRoleRequestDto;
import com.mera.shine.dto.response.GroupsRoleDto;
import com.mera.shine.entity.Group;
import com.mera.shine.entity.GroupsRole;
import com.mera.shine.entity.Role;
import com.mera.shine.mapper.GroupsRoleMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the GroupsRoleMapper interface.
 */
@Component
public class GroupsRoleMapperImpl implements GroupsRoleMapper {

    @Override
    public GroupsRoleDto toDto(GroupsRole entity) {
        if (entity == null) {
            return null;
        }

        Integer idgroupId = null;
        if (entity.getIdgroup() != null) {
            idgroupId = entity.getIdgroup().getId();
        }

        Integer accesId = null;
        if (entity.getAcces() != null) {
            accesId = entity.getAcces().getId();
        }

        return new GroupsRoleDto(
                entity.getId(),
                idgroupId,
                accesId
        );
    }

    @Override
    public GroupsRole toEntity(GroupsRoleDto dto) {
        if (dto == null) {
            return null;
        }

        GroupsRole groupsRole = new GroupsRole();
        groupsRole.setId(dto.id());

        if (dto.idgroupId() != null) {
            Group group = new Group();
            group.setId(dto.idgroupId());
            groupsRole.setIdgroup(group);
        }

        if (dto.accesId() != null) {
            Role role = new Role();
            role.setId(dto.accesId());
            groupsRole.setAcces(role);
        }

        return groupsRole;
    }

    @Override
    public GroupsRole createDtoToEntity(CreateGroupsRoleRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        GroupsRole groupsRole = new GroupsRole();

        if (createDto.idgroupId() != null) {
            Group group = new Group();
            group.setId(createDto.idgroupId());
            groupsRole.setIdgroup(group);
        }

        if (createDto.accesId() != null) {
            Role role = new Role();
            role.setId(createDto.accesId());
            groupsRole.setAcces(role);
        }

        return groupsRole;
    }

    @Override
    public GroupsRole updateEntityFromDto(GroupsRoleDto dto, GroupsRole entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        if (dto.idgroupId() != null) {
            if (entity.getIdgroup() == null || !entity.getIdgroup().getId().equals(dto.idgroupId())) {
                Group group = new Group();
                group.setId(dto.idgroupId());
                entity.setIdgroup(group);
            }
        } else {
            entity.setIdgroup(null);
        }

        if (dto.accesId() != null) {
            if (entity.getAcces() == null || !entity.getAcces().getId().equals(dto.accesId())) {
                Role role = new Role();
                role.setId(dto.accesId());
                entity.setAcces(role);
            }
        } else {
            entity.setAcces(null);
        }

        return entity;
    }
}