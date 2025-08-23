package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateRoleRequestDto;
import com.mera.shine.dto.response.RoleDto;
import com.mera.shine.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Role entities.
 */
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * GET /api/roles : Get all roles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of roles in body
     */
    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    /**
     * GET /api/roles/{id} : Get the "id" role.
     *
     * @param id the id of the role to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the role, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable Integer id) {
        return roleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/roles : Create a new role.
     *
     * @param createRoleDto the role to create
     * @return the ResponseEntity with status 201 (Created) and with body the new role
     */
    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody CreateRoleRequestDto createRoleDto) {
        RoleDto result = roleService.create(createRoleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/roles/{id} : Updates an existing role.
     *
     * @param id the id of the role to update
     * @param roleDto the role to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated role,
     * or with status 404 (Not Found) if the role is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(
            @PathVariable Integer id,
            @RequestBody RoleDto roleDto) {
        try {
            RoleDto result = roleService.update(id, roleDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/roles/{id} : Delete the "id" role.
     *
     * @param id the id of the role to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}