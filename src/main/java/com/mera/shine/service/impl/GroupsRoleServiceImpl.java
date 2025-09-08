package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateGroupsRoleRequestDto;
import com.mera.shine.dto.response.GroupsRoleDto;
import com.mera.shine.entity.GroupsRole;
import com.mera.shine.mapper.GroupsRoleMapper;
import com.mera.shine.repository.GroupsRoleRepository;
import com.mera.shine.service.GroupsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the GroupsRoleService interface.
 */
@Service
@Transactional
public  class GroupsRoleServiceImpl implements GroupsRoleService {

    private final GroupsRoleRepository groupsRoleRepository;
    private final GroupsRoleMapper groupsRoleMapper;

    @Autowired
    public GroupsRoleServiceImpl(GroupsRoleRepository groupsRoleRepository, GroupsRoleMapper groupsRoleMapper) {
        this.groupsRoleRepository = groupsRoleRepository;
        this.groupsRoleMapper = groupsRoleMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupsRoleDto> findAll() {
        return groupsRoleRepository.findAll().stream()
                .map(groupsRoleMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<GroupsRoleDto> findById(Integer id) {
        return groupsRoleRepository.findById(id)
                .map(groupsRoleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupsRoleDto> findByIdGroup(Integer idGroup) {
        return groupsRoleRepository.findByIdGroup(idGroup).stream()
                .map(groupsRoleMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    @Transactional
    public GroupsRoleDto create(CreateGroupsRoleRequestDto createGroupsRoleDto) {
        GroupsRole groupsRole = groupsRoleMapper.createDtoToEntity(createGroupsRoleDto);
        groupsRole = groupsRoleRepository.save(groupsRole);
        return groupsRoleMapper.toDto(groupsRole);
    }

    @Override
    @Transactional
    public GroupsRoleDto update(Integer id, GroupsRoleDto groupsRoleDto) {
        return groupsRoleRepository.findById(id)
                .map(existingGroupsRole -> {
                    GroupsRole updatedGroupsRole = groupsRoleMapper.updateEntityFromDto(groupsRoleDto, existingGroupsRole);
                    updatedGroupsRole = groupsRoleRepository.save(updatedGroupsRole);
                    return groupsRoleMapper.toDto(updatedGroupsRole);
                })
                .orElseThrow(() -> new RuntimeException("GroupsRole not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        groupsRoleRepository.deleteById(id);
    }
}
