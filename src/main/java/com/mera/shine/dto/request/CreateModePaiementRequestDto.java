package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.ModePaiement}
 */
public record CreateModePaiementRequestDto(
    @NotNull
    @Size(max = 255)
    String mpNom,
    
    @NotNull
    Integer mpVirgule,
    
    @NotNull
    Integer societeId
) {
}