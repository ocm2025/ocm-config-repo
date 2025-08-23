package com.mera.shine.dto.response;

import java.util.Set;

/**
 * DTO for {@link com.mera.shine.entity.LigneConditionPaiement}
 */
public record LigneConditionPaiementDto(
    Integer id,
    String lcpNom,
    String lcpDescription,
    Integer societeId,
    Set<Integer> itemsConditionPaiementIds
) {
}