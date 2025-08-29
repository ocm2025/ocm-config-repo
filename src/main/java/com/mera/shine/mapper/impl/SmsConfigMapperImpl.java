package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateSmsConfigRequestDto;
import com.mera.shine.dto.response.SmsConfigDto;
import com.mera.shine.entity.SmsConfig;
import com.mera.shine.mapper.SmsConfigMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the SmsConfigMapper interface.
 */
@Component
public class SmsConfigMapperImpl implements SmsConfigMapper {

    @Override
    public SmsConfigDto toDto(SmsConfig entity) {
        if (entity == null) {
            return null;
        }

        return new SmsConfigDto(
                entity.getId(),
                entity.getSenderId(),
                entity.getAuthKey(),
                entity.getContact(),
                entity.getSociete()
        );
    }

    @Override
    public SmsConfig toEntity(SmsConfigDto dto) {
        if (dto == null) {
            return null;
        }

        SmsConfig smsConfig = new SmsConfig();
        smsConfig.setId(dto.id());
        smsConfig.setSenderId(dto.senderId());
        smsConfig.setAuthKey(dto.authKey());
        smsConfig.setContact(dto.contact());
        smsConfig.setSociete(dto.societe());

        return smsConfig;
    }

    @Override
    public SmsConfig createDtoToEntity(CreateSmsConfigRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        SmsConfig smsConfig = new SmsConfig();
        smsConfig.setSenderId(createDto.senderId());
        smsConfig.setAuthKey(createDto.authKey());
        smsConfig.setContact(createDto.contact());
        smsConfig.setSociete(createDto.societe());

        return smsConfig;
    }

    @Override
    public SmsConfig updateEntityFromDto(SmsConfigDto dto, SmsConfig entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setSenderId(dto.senderId());
        entity.setAuthKey(dto.authKey());
        entity.setContact(dto.contact());
        entity.setSociete(dto.societe());

        return entity;
    }
}