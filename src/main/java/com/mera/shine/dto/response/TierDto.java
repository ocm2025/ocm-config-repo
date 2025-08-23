package com.mera.shine.dto.response;

import java.util.Set;

/**
 * DTO for {@link com.mera.shine.entity.Tier}
 */
public record TierDto(
    Integer id,
    String clCode,
    String clNom,
    String clNc,
    String clRccm,
    String clTelephone,
    String clEmail,
    Integer clStatutFiscal,
    String clDescription,
    Short clIsDefaut,
    Integer clType,
    Integer conditionPaiementId,
    Integer zoneId,
    Integer taxeId,
    Integer groupeId,
    Integer societeId,
    Set<Integer> adresseIds
) {
}