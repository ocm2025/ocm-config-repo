package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateLanguageRequestDto;
import com.mera.shine.dto.response.LanguageDto;
import com.mera.shine.entity.Language;
import com.mera.shine.mapper.LanguageMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the LanguageMapper interface.
 */
@Component
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageDto toDto(Language entity) {
        if (entity == null) {
            return null;
        }

        return new LanguageDto(
                entity.getId(),
                entity.getName(),
                entity.getSlug(),
                entity.getCode()
        );
    }

    @Override
    public Language toEntity(LanguageDto dto) {
        if (dto == null) {
            return null;
        }

        Language language = new Language();
        language.setId(dto.id());
        language.setName(dto.name());
        language.setSlug(dto.slug());
        language.setCode(dto.code());

        return language;
    }

    @Override
    public Language createDtoToEntity(CreateLanguageRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Language language = new Language();
        language.setName(createDto.name());
        language.setSlug(createDto.slug());
        language.setCode(createDto.code());

        return language;
    }

    @Override
    public Language updateEntityFromDto(LanguageDto dto, Language entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setName(dto.name());
        entity.setSlug(dto.slug());
        entity.setCode(dto.code());

        return entity;
    }
}