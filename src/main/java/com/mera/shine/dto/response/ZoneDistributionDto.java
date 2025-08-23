package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.ZoneDistribution}
 */
public record ZoneDistributionDto(
    Integer id,
    String zdCode,
    String zdLibelle,
    Integer siteId
) {
}