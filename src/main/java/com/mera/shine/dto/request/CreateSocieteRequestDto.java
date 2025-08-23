package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Societe}
 */
public record CreateSocieteRequestDto(
    @NotNull
    @Size(max = 255)
    String sNom,
    
    @NotNull
    @Size(max = 255)
    String sActivite,
    
    @Size(max = 255)
    String sAdresse,
    
    @Size(max = 255)
    String sBoitePostal,
    
    @NotNull
    @Size(max = 255)
    String sPays,
    
    @Size(max = 255)
    String sRegion,
    
    @Size(max = 255)
    String sTelephone,
    
    @NotNull
    @Size(max = 255)
    String sNc,
    
    @NotNull
    @Size(max = 255)
    String sRccm,
    
    @NotNull
    @Size(max = 255)
    String sRegimeFiscal,
    
    @NotNull
    @Size(max = 255)
    String sDevise,
    
    @Size(max = 255)
    String sLogo,
    
    @Size(max = 255)
    String sFovicon
) {
}