package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Emplacement}
 */
public record EmplacementDto(
    Integer id,
    String emNom,
    String emCode,
    Integer siteId
) {
}