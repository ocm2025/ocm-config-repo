package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Taxe}
 */
public record TaxeDto(
    Integer id,
    String taxNom,
    Integer type,
    Double taxValeur,
    Integer taxNature,
    Integer taxIsRetenue,
    Integer societeId
) {
}