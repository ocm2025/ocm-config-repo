package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateEmailConfigRequestDto;
import com.mera.shine.dto.response.EmailConfigDto;
import com.mera.shine.entity.EmailConfig;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.EmailConfigMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the EmailConfigMapper interface.
 */
@Component
public class EmailConfigMapperImpl implements EmailConfigMapper {

    @Override
    public EmailConfigDto toDto(EmailConfig entity) {
        if (entity == null) {
            return null;
        }

        return new EmailConfigDto(
                entity.getId(),
                entity.getHost(),
                entity.getPort(),
                entity.getAuth(),
                entity.getAuthType(),
                entity.getUsername(),
                entity.getPasswordTxt(),
                entity.getFromAdress(),
                entity.getFromName(),
                entity.getSociete() != null ? entity.getSociete().getId() : null
        );
    }

    @Override
    public EmailConfig toEntity(EmailConfigDto dto) {
        if (dto == null) {
            return null;
        }

        EmailConfig emailConfig = new EmailConfig();
        emailConfig.setId(dto.id());
        emailConfig.setHost(dto.host());
        emailConfig.setPort(dto.port());
        emailConfig.setAuth(dto.auth());
        emailConfig.setAuthType(dto.authType());
        emailConfig.setUsername(dto.username());
        emailConfig.setPasswordTxt(dto.passwordTxt());
        emailConfig.setFromAdress(dto.fromAdress());
        emailConfig.setFromName(dto.fromName());
        
        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            emailConfig.setSociete(societe);
        }

        return emailConfig;
    }

    @Override
    public EmailConfig createDtoToEntity(CreateEmailConfigRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        EmailConfig emailConfig = new EmailConfig();
        emailConfig.setHost(createDto.host());
        emailConfig.setPort(createDto.port());
        emailConfig.setAuth(createDto.auth());
        emailConfig.setAuthType(createDto.authType());
        emailConfig.setUsername(createDto.username());
        emailConfig.setPasswordTxt(createDto.passwordTxt());
        emailConfig.setFromAdress(createDto.fromAdress());
        emailConfig.setFromName(createDto.fromName());
        
        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            emailConfig.setSociete(societe);
        }

        return emailConfig;
    }

    @Override
    public EmailConfig updateEntityFromDto(EmailConfigDto dto, EmailConfig entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setHost(dto.host());
        entity.setPort(dto.port());
        entity.setAuth(dto.auth());
        entity.setAuthType(dto.authType());
        entity.setUsername(dto.username());
        entity.setPasswordTxt(dto.passwordTxt());
        entity.setFromAdress(dto.fromAdress());
        entity.setFromName(dto.fromName());
        
        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            entity.setSociete(societe);
        } else {
            entity.setSociete(null);
        }

        return entity;
    }
}