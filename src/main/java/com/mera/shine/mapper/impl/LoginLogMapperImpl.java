package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateLoginLogRequestDto;
import com.mera.shine.dto.response.LoginLogDto;
import com.mera.shine.entity.LoginLog;
import com.mera.shine.mapper.LoginLogMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * Implementation of the LoginLogMapper interface.
 */
@Component
public class LoginLogMapperImpl implements LoginLogMapper {

    @Override
    public LoginLogDto toDto(LoginLog entity) {
        if (entity == null) {
            return null;
        }

        return new LoginLogDto(
                entity.getId(),
                entity.getUserId(),
                entity.getUsername(),
                entity.getIp(),
                entity.getCreatedAt()
        );
    }

    @Override
    public LoginLog toEntity(LoginLogDto dto) {
        if (dto == null) {
            return null;
        }

        LoginLog loginLog = new LoginLog();
        loginLog.setId(dto.id());
        loginLog.setUserId(dto.userId());
        loginLog.setUsername(dto.username());
        loginLog.setIp(dto.ip());
        loginLog.setCreatedAt(dto.createdAt());

        return loginLog;
    }

    @Override
    public LoginLog createDtoToEntity(CreateLoginLogRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(createDto.userId());
        loginLog.setUsername(createDto.username());
        loginLog.setIp(createDto.ip());
        loginLog.setCreatedAt(Instant.now()); // Set current time for new entities

        return loginLog;
    }

    @Override
    public LoginLog updateEntityFromDto(LoginLogDto dto, LoginLog entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setUserId(dto.userId());
        entity.setUsername(dto.username());
        entity.setIp(dto.ip());
        // We don't update createdAt as it should remain the original creation time

        return entity;
    }
}