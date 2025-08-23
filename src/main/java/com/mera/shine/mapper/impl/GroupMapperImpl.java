package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateGroupRequestDto;
import com.mera.shine.dto.response.GroupDto;
import com.mera.shine.entity.Group;
import com.mera.shine.entity.GroupsRole;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.GroupMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the GroupMapper interface.
 */
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupDto toDto(Group entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        Set<Integer> groupsRoleIds = null;
        if (entity.getGroupsRoles() != null) {
            groupsRoleIds = entity.getGroupsRoles().stream()
                    .map(GroupsRole::getId)
                    .collect(Collectors.toSet());
        }

        return new GroupDto(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getIsActive(),
                societeId,
                groupsRoleIds
        );
    }

    @Override
    public Group toEntity(GroupDto dto) {
        if (dto == null) {
            return null;
        }

        Group group = new Group();
        group.setId(dto.id());
        group.setName(dto.name());
        group.setType(dto.type());
        group.setIsActive(dto.isActive());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            group.setSociete(societe);
        }

        // We don't set groupsRoles here as it's a one-to-many relationship
        // and would require loading the actual GroupsRole entities

        return group;
    }

    @Override
    public Group createDtoToEntity(CreateGroupRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Group group = new Group();
        group.setName(createDto.name());
        group.setType(createDto.type());
        group.setIsActive(createDto.isActive());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            group.setSociete(societe);
        }

        group.setGroupsRoles(new HashSet<>());

        return group;
    }

    @Override
    public Group updateEntityFromDto(GroupDto dto, Group entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setName(dto.name());
        entity.setType(dto.type());
        entity.setIsActive(dto.isActive());

        if (dto.societeId() != null) {
            if (entity.getSociete() == null || !entity.getSociete().getId().equals(dto.societeId())) {
                Societe societe = new Societe();
                societe.setId(dto.societeId());
                entity.setSociete(societe);
            }
        } else {
            entity.setSociete(null);
        }

        // We don't update groupsRoles here as it's a one-to-many relationship
        // and would require loading the actual GroupsRole entities

        return entity;
    }
}