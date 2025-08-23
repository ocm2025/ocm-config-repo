package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.CurrencyToSite}
 */
public record CurrencyToSiteDto(
    Integer id,
    Integer currencyId,
    Integer siteId,
    Boolean status
) {
}