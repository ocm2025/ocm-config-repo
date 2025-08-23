package com.mera.shine.service;

import com.mera.shine.dto.request.CreateGroupsRoleRequestDto;
import com.mera.shine.dto.response.GroupsRoleDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing GroupsRole entities.
 */
public interface GroupsRoleService {
    
    /**
     * Get all group roles.
     *
     * @return list of all group roles
     */
    List<GroupsRoleDto> findAll();
    

    /**
     * Get a group role by its ID.
     *
     * @param id the ID of the group role
     * @return the group role if found
     */
    Optional<GroupsRoleDto> findById(Integer id);

    /**
     * Create a new group role.
     *
     * @param createGroupsRoleDto the group role to create
     * @return the created group role
     */
    GroupsRoleDto create(CreateGroupsRoleRequestDto createGroupsRoleDto);
    
    /**
     * Update an existing group role.
     *
     * @param id the ID of the group role to update
     * @param groupsRoleDto the updated group role data
     * @return the updated group role
     */
    GroupsRoleDto update(Integer id, GroupsRoleDto groupsRoleDto);
    
    /**
     * Delete a group role by its ID.
     *
     * @param id the ID of the group role to delete
     */
    void delete(Integer id);
}