package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateEmailConfigRequestDto;
import com.mera.shine.dto.response.EmailConfigDto;
import com.mera.shine.entity.EmailConfig;

/**
 * Mapper for the EmailConfig entity and its DTOs.
 */
public interface EmailConfigMapper extends EntityMapper<EmailConfig, EmailConfigDto, CreateEmailConfigRequestDto> {
}