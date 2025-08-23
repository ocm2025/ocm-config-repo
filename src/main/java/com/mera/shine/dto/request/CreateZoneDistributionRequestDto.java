package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.ZoneDistribution}
 */
public record CreateZoneDistributionRequestDto(
    @NotNull
    @Size(max = 255)
    String zdCode,
    
    @Size(max = 255)
    String zdLibelle,
    
    Integer siteId
) {
}