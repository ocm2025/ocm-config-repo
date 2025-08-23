package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO for creating {@link com.mera.shine.entity.GroupsRole}
 */
public record CreateGroupsRoleRequestDto(
    @NotNull
    Integer idgroupId,
    
    @NotNull
    Integer accesId
) {
}