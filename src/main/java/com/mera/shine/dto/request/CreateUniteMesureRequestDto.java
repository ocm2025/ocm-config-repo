package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.UniteMesure}
 */
public record CreateUniteMesureRequestDto(
    @NotNull
    @Size(max = 255)
    String umCode,
    
    @NotNull
    @Size(max = 255)
    String umLibelle,
    
    @NotNull
    Integer umIsReference,
    
    @NotNull
    Integer societeId
) {
}