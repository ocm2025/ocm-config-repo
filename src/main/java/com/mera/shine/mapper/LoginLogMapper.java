package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateLoginLogRequestDto;
import com.mera.shine.dto.response.LoginLogDto;
import com.mera.shine.entity.LoginLog;

/**
 * Mapper for the LoginLog entity and its DTOs.
 */
public interface LoginLogMapper extends EntityMapper<LoginLog, LoginLogDto, CreateLoginLogRequestDto> {
}