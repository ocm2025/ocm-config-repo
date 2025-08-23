package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateRoleRequestDto;
import com.mera.shine.dto.response.RoleDto;
import com.mera.shine.entity.Role;
import com.mera.shine.mapper.RoleMapper;
import com.mera.shine.repository.RoleRepository;
import com.mera.shine.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the RoleService interface.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Transactional(readOnly = true)
    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<RoleDto> findById(Integer id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDto);
    }

    @Transactional
    public RoleDto create(CreateRoleRequestDto createRoleDto) {
        Role role = roleMapper.createDtoToEntity(createRoleDto);
        role = roleRepository.save(role);
        return roleMapper.toDto(role);
    }

    @Transactional
    public RoleDto update(Integer id, RoleDto roleDto) {
        return roleRepository.findById(id)
                .map(existingRole -> {
                    Role updatedRole = roleMapper.updateEntityFromDto(roleDto, existingRole);
                    updatedRole = roleRepository.save(updatedRole);
                    return roleMapper.toDto(updatedRole);
                })
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }
}