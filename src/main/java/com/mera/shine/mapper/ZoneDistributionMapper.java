package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateZoneDistributionRequestDto;
import com.mera.shine.dto.response.ZoneDistributionDto;
import com.mera.shine.entity.ZoneDistribution;

/**
 * Mapper for the ZoneDistribution entity and its DTOs.
 */
public interface ZoneDistributionMapper extends EntityMapper<ZoneDistribution, ZoneDistributionDto, CreateZoneDistributionRequestDto> {
}