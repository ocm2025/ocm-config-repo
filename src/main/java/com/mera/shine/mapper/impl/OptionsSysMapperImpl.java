package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateOptionsSysRequestDto;
import com.mera.shine.dto.response.OptionsSysDto;
import com.mera.shine.entity.OptionsSys;
import com.mera.shine.mapper.OptionsSysMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the OptionsSysMapper interface.
 */
@Component
public class OptionsSysMapperImpl implements OptionsSysMapper {

    @Override
    public OptionsSysDto toDto(OptionsSys entity) {
        if (entity == null) {
            return null;
        }

        return new OptionsSysDto(
                entity.getId(),
                entity.getOsCode(),
                entity.getOsLibelle(),
                entity.getOsMessage()
        );
    }

    @Override
    public OptionsSys toEntity(OptionsSysDto dto) {
        if (dto == null) {
            return null;
        }

        OptionsSys optionsSys = new OptionsSys();
        optionsSys.setId(dto.id());
        optionsSys.setOsCode(dto.osCode());
        optionsSys.setOsLibelle(dto.osLibelle());
        optionsSys.setOsMessage(dto.osMessage());

        return optionsSys;
    }

    @Override
    public OptionsSys createDtoToEntity(CreateOptionsSysRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        OptionsSys optionsSys = new OptionsSys();
        optionsSys.setOsCode(createDto.osCode());
        optionsSys.setOsLibelle(createDto.osLibelle());
        optionsSys.setOsMessage(createDto.osMessage());

        return optionsSys;
    }

    @Override
    public OptionsSys updateEntityFromDto(OptionsSysDto dto, OptionsSys entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setOsCode(dto.osCode());
        entity.setOsLibelle(dto.osLibelle());
        entity.setOsMessage(dto.osMessage());

        return entity;
    }
}