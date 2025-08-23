package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO for creating {@link com.mera.shine.entity.CurrencyToSite}
 */
public record CreateCurrencyToSiteRequestDto(
    @NotNull
    Integer currencyId,
    
    @NotNull
    Integer siteId,
    
    @NotNull
    Boolean status
) {
}