package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateGroupRequestDto;
import com.mera.shine.dto.response.GroupDto;
import com.mera.shine.entity.Group;
import com.mera.shine.mapper.GroupMapper;
import com.mera.shine.repository.GroupRepository;
import com.mera.shine.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the GroupService interface.
 */
@Service
@Transactional
public  class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Transactional(readOnly = true)
    public List<GroupDto> findAll() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public Optional<GroupDto> findById(Integer id) {
        return groupRepository.findById(id)
                .map(groupMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<GroupDto> findBySocieteId(Integer societeId) {
        return groupRepository.findBySocieteId(societeId).stream()
                .map(groupMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public GroupDto create(CreateGroupRequestDto createGroupDto) {
        Group group = groupMapper.createDtoToEntity(createGroupDto);
        group = groupRepository.save(group);
        return groupMapper.toDto(group);
    }

    @Transactional
    public GroupDto update(Integer id, GroupDto groupDto) {
        return groupRepository.findById(id)
                .map(existingGroup -> {
                    Group updatedGroup = groupMapper.updateEntityFromDto(groupDto, existingGroup);
                    updatedGroup = groupRepository.save(updatedGroup);
                    return groupMapper.toDto(updatedGroup);
                })
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        groupRepository.deleteById(id);
    }


}
