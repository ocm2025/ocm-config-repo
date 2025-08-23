package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Taxe}
 */
public record CreateTaxeRequestDto(
    @NotNull
    @Size(max = 255)
    String taxNom,
    
    @NotNull
    Integer type,
    
    @NotNull
    Double taxValeur,
    
    @NotNull
    Integer taxNature,
    
    @NotNull
    Integer taxIsRetenue,
    
    @NotNull
    Integer societeId
) {
}