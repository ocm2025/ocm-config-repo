package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateGroupRequestDto;
import com.mera.shine.dto.response.GroupDto;
import com.mera.shine.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Group entities.
 */
@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * GET /api/groups : Get all groups.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of groups in body
     */
    @GetMapping
    public ResponseEntity<List<GroupDto>> getAllGroups() {
        List<GroupDto> groups = groupService.findAll();
        return ResponseEntity.ok(groups);
    }

    /**
     * GET /api/groups/{id} : Get the "id" group.
     *
     * @param id the id of the group to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the group, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> getGroup(@PathVariable Integer id) {
        return groupService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/groups : Create a new group.
     *
     * @param createGroupDto the group to create
     * @return the ResponseEntity with status 201 (Created) and with body the new group
     */
    @PostMapping
    public ResponseEntity<GroupDto> createGroup(@RequestBody CreateGroupRequestDto createGroupDto) {
        GroupDto result = groupService.create(createGroupDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/groups/{id} : Updates an existing group.
     *
     * @param id the id of the group to update
     * @param groupDto the group to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated group,
     * or with status 404 (Not Found) if the group is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<GroupDto> updateGroup(
            @PathVariable Integer id,
            @RequestBody GroupDto groupDto) {
        try {
            GroupDto result = groupService.update(id, groupDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/groups/{id} : Delete the "id" group.
     *
     * @param id the id of the group to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Integer id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}