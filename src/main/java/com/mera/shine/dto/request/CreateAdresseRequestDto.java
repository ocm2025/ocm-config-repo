package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Adresse}
 */
public record CreateAdresseRequestDto(
    @NotNull
    Short afType,
    
    @Size(max = 255)
    String afRue,
    
    @Size(max = 255)
    String afVille,
    
    @Size(max = 255)
    String afPays,
    
    @Size(max = 255)
    String afCodePostal,
    
    Integer tiersId
) {
}