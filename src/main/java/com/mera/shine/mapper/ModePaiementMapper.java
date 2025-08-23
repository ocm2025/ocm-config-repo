package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateModePaiementRequestDto;
import com.mera.shine.dto.response.ModePaiementDto;
import com.mera.shine.entity.ModePaiement;

/**
 * Mapper for the ModePaiement entity and its DTOs.
 */
public interface ModePaiementMapper extends EntityMapper<ModePaiement, ModePaiementDto, CreateModePaiementRequestDto> {
}