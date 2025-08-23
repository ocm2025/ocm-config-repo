package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateRoleRequestDto;
import com.mera.shine.dto.response.RoleDto;
import com.mera.shine.entity.Role;

/**
 * Mapper for the Role entity and its DTOs.
 */
public interface RoleMapper extends EntityMapper<Role, RoleDto, CreateRoleRequestDto> {
}