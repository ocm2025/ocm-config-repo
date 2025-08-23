package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.GroupsRole}
 */
public record GroupsRoleDto(
    Integer id,
    Integer idgroupId,
    Integer accesId
) {
}