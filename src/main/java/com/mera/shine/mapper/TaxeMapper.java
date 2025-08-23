package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateTaxeRequestDto;
import com.mera.shine.dto.response.TaxeDto;
import com.mera.shine.entity.Taxe;

/**
 * Mapper for the Taxe entity and its DTOs.
 */
public interface TaxeMapper extends EntityMapper<Taxe, TaxeDto, CreateTaxeRequestDto> {
}