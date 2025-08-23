package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateGroupsRoleRequestDto;
import com.mera.shine.dto.response.GroupsRoleDto;
import com.mera.shine.service.GroupsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing GroupsRole entities.
 */
@RestController
@RequestMapping("/api/groups-roles")
public class GroupsRoleController {

    private final GroupsRoleService groupsRoleService;

    @Autowired
    public GroupsRoleController(GroupsRoleService groupsRoleService) {
        this.groupsRoleService = groupsRoleService;
    }

    /**
     * GET /api/groups-roles : Get all group roles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of group roles in body
     */
    @GetMapping
    public ResponseEntity<List<GroupsRoleDto>> getAllGroupsRoles() {
        List<GroupsRoleDto> groupsRoles = groupsRoleService.findAll();
        return ResponseEntity.ok(groupsRoles);
    }



    /**
     * POST /api/groups-roles : Create a new group role.
     *
     * @param createGroupsRoleDto the group role to create
     * @return the ResponseEntity with status 201 (Created) and with body the new group role
     */
    @PostMapping
    public ResponseEntity<GroupsRoleDto> createGroupsRole(@RequestBody CreateGroupsRoleRequestDto createGroupsRoleDto) {
        GroupsRoleDto result = groupsRoleService.create(createGroupsRoleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/groups-roles/{id} : Updates an existing group role.
     *
     * @param id the id of the group role to update
     * @param groupsRoleDto the group role to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated group role,
     * or with status 404 (Not Found) if the group role is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<GroupsRoleDto> updateGroupsRole(
            @PathVariable Integer id,
            @RequestBody GroupsRoleDto groupsRoleDto) {
        try {
            GroupsRoleDto result = groupsRoleService.update(id, groupsRoleDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/groups-roles/{id} : Delete the "id" group role.
     *
     * @param id the id of the group role to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupsRole(@PathVariable Integer id) {
        groupsRoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}