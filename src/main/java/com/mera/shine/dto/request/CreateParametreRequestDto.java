package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Parametre}
 */
public record CreateParametreRequestDto(
    @NotNull
    @Size(max = 12)
    String csCode,
    
    @Size(max = 255)
    String csLibelle,
    
    Byte csIsValid,
    
    @Size(max = 255)
    String message,
    
    Integer societeId,
    
    Integer siteId
) {
}