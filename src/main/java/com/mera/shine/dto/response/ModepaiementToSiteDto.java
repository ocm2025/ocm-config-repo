package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.ModepaiementToSite}
 */
public record ModepaiementToSiteDto(
    Integer id,
    Integer modepaiementId,
    Integer siteId,
    Boolean status
) {
}