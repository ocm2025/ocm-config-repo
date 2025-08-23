package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Tier}
 */
public record CreateTierRequestDto(
    @NotNull
    @Size(max = 25)
    String clCode,
    
    @NotNull
    @Size(max = 255)
    String clNom,
    
    @Size(max = 255)
    String clNc,
    
    @Size(max = 255)
    String clRccm,
    
    @Size(max = 255)
    String clTelephone,
    
    @Size(max = 255)
    String clEmail,
    
    @NotNull
    Integer clStatutFiscal,
    
    @Size(max = 255)
    String clDescription,
    
    @NotNull
    Short clIsDefaut,
    
    @NotNull
    Integer clType,
    
    Integer conditionPaiementId,
    
    Integer zoneId,
    
    Integer taxeId,
    
    Integer groupeId,
    
    @NotNull
    Integer societeId
) {
}