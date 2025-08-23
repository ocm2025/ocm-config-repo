package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO for creating {@link com.mera.shine.entity.TiersToSite}
 */
public record CreateTiersToSiteRequestDto(
    @NotNull
    Integer tiersId,
    
    @NotNull
    Integer siteId,
    
    @NotNull
    Boolean status
) {
}