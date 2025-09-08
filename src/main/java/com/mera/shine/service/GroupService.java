package com.mera.shine.service;

import com.mera.shine.dto.request.CreateGroupRequestDto;
import com.mera.shine.dto.response.GroupDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Group entities.
 */
public interface GroupService {

    /**
     * Get all groups.
     *
     * @return list of all groups
     */
    List<GroupDto> findAll();


    /**
     * Get a group by its ID.
     *
     * @param id the ID of the group
     * @return the group if found
     */
    Optional<GroupDto> findById(Integer id);

    /**
     * Find groups by société ID.
     *
     * @param societeId the société ID
     * @return list of groups belonging to the société
     */
    List<GroupDto> findBySocieteId(Integer societeId);

    /**
     * Create a new group.
     *
     * @param createGroupDto the group to create
     * @return the created group
     */
    GroupDto create(CreateGroupRequestDto createGroupDto);

    /**
     * Update an existing group.
     *
     * @param id the ID of the group to update
     * @param groupDto the updated group data
     * @return the updated group
     */
    GroupDto update(Integer id, GroupDto groupDto);

    /**
     * Delete a group by its ID.
     *
     * @param id the ID of the group to delete
     */
    void delete(Integer id);
}
