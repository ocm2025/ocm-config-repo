package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateSmsConfigRequestDto;
import com.mera.shine.dto.response.SmsConfigDto;
import com.mera.shine.entity.SmsConfig;

/**
 * Mapper for the SmsConfig entity and its DTOs.
 */
public interface SmsConfigMapper extends EntityMapper<SmsConfig, SmsConfigDto, CreateSmsConfigRequestDto> {
}