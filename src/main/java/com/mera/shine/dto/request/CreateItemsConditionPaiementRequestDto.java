package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;

/**
 * DTO for creating {@link com.mera.shine.entity.ItemsConditionPaiement}
 */
public record CreateItemsConditionPaiementRequestDto(
    @NotNull
    Integer icpTypeEcheance,
    
    @NotNull
    Integer cpiValeur,
    
    @NotNull
    Integer icpDelais,
    
    @NotNull
    Integer conditionPaiementId
) {
}