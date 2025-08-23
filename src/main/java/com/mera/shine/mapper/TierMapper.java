package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateTierRequestDto;
import com.mera.shine.dto.response.TierDto;
import com.mera.shine.entity.Tier;

/**
 * Mapper for the Tier entity and its DTOs.
 */
public interface TierMapper extends EntityMapper<Tier, TierDto, CreateTierRequestDto> {
}