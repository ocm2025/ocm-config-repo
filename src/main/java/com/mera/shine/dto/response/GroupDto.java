package com.mera.shine.dto.response;

import java.util.Set;

/**
 * DTO for {@link com.mera.shine.entity.Group}
 */
public record GroupDto(
    Integer id,
    String name,
    Integer type,
    Integer isActive,
    Integer societeId,
    Set<Integer> groupsRoleIds
) {
}