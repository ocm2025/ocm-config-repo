package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO for creating {@link com.mera.shine.entity.ModepaiementToSite}
 */
public record CreateModepaiementToSiteRequestDto(
    @NotNull
    Integer modepaiementId,
    
    @NotNull
    Integer siteId,
    
    @NotNull
    Boolean status
) {
}