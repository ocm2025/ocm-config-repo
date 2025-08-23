package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateUniteMesureRequestDto;
import com.mera.shine.dto.response.UniteMesureDto;
import com.mera.shine.entity.UniteMesure;

/**
 * Mapper for the UniteMesure entity and its DTOs.
 */
public interface UniteMesureMapper extends EntityMapper<UniteMesure, UniteMesureDto, CreateUniteMesureRequestDto> {
}