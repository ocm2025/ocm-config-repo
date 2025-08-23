package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateLigneConditionPaiementRequestDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;
import com.mera.shine.entity.LigneConditionPaiement;

/**
 * Mapper for the LigneConditionPaiement entity and its DTOs.
 */
public interface LigneConditionPaiementMapper extends EntityMapper<LigneConditionPaiement, LigneConditionPaiementDto, CreateLigneConditionPaiementRequestDto> {
}