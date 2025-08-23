package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Site}
 */
public record CreateSiteRequestDto(
    @NotNull
    @Size(max = 255)
    String pvNom,
    
    @NotNull
    @Size(max = 20)
    String pvCode,
    
    @Size(max = 255)
    String pvDescription,
    
    @Size(max = 255)
    String pvVille,
    
    @Size(max = 255)
    String pvPays,
    
    @NotNull
    Short pvGetEmplacement,
    
    @NotNull
    Integer societeId
) {
}