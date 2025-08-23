package com.mera.shine.service;

import com.mera.shine.dto.request.CreateRoleRequestDto;
import com.mera.shine.dto.response.RoleDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Role entities.
 */
public interface RoleService {
    
    /**
     * Get all roles.
     *
     * @return list of all roles
     */
    List<RoleDto> findAll();
    
    /**
     * Get a role by its ID.
     *
     * @param id the ID of the role
     * @return the role if found
     */
    Optional<RoleDto> findById(Integer id);
    

    /**
     * Create a new role.
     *
     * @param createRoleDto the role to create
     * @return the created role
     */
    RoleDto create(CreateRoleRequestDto createRoleDto);
    
    /**
     * Update an existing role.
     *
     * @param id the ID of the role to update
     * @param roleDto the updated role data
     * @return the updated role
     */
    RoleDto update(Integer id, RoleDto roleDto);
    
    /**
     * Delete a role by its ID.
     *
     * @param id the ID of the role to delete
     */
    void delete(Integer id);
}