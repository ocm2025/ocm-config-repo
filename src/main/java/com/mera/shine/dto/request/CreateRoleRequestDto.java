package com.mera.shine.dto.request;

import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Role}
 */
public record CreateRoleRequestDto(
    Integer code,
    
    @Size(max = 255)
    String libelle
) {
}