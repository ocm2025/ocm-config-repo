package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.ModePaiement}
 */
public record ModePaiementDto(
    Integer id,
    String mpNom,
    Integer mpVirgule,
    Integer societeId
) {
}