package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Role}
 */
public record RoleDto(
    Integer id,
    Integer code,
    String libelle
) {
}