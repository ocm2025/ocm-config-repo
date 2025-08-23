package com.mera.shine.dto.request;

import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Group}
 */
public record CreateGroupRequestDto(
    @Size(max = 255)
    String name,
    
    Integer type,
    
    Integer isActive,
    
    Integer societeId
) {
}