package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.ItemsConditionPaiement}
 */
public record ItemsConditionPaiementDto(
    Integer id,
    Integer icpTypeEcheance,
    Integer cpiValeur,
    Integer icpDelais,
    Integer conditionPaiementId
) {
}