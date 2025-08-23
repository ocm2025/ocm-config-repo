package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.LigneConditionPaiement}
 */
public record CreateLigneConditionPaiementRequestDto(
    @NotNull
    @Size(max = 255)
    String lcpNom,
    
    @Size(max = 255)
    String lcpDescription,
    
    @NotNull
    Integer societeId
) {
}