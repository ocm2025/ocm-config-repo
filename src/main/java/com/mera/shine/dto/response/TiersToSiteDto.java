package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.TiersToSite}
 */
public record TiersToSiteDto(
    Integer id,
    Integer tiersId,
    Integer siteId,
    Boolean status
) {
}