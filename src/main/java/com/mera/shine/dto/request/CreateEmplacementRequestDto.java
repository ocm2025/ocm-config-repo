package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Emplacement}
 */
public record CreateEmplacementRequestDto(
    @NotNull
    @Size(max = 255)
    String emNom,
    
    @NotNull
    @Size(max = 12)
    String emCode,
    
    @NotNull
    Integer siteId
) {
}