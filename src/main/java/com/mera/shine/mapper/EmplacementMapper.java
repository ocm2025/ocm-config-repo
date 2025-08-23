package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateEmplacementRequestDto;
import com.mera.shine.dto.response.EmplacementDto;
import com.mera.shine.entity.Emplacement;

/**
 * Mapper for the Emplacement entity and its DTOs.
 */
public interface EmplacementMapper extends EntityMapper<Emplacement, EmplacementDto, CreateEmplacementRequestDto> {
}