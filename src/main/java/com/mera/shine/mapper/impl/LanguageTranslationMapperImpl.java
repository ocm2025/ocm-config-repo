package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateLanguageTranslationRequestDto;
import com.mera.shine.dto.response.LanguageTranslationDto;
import com.mera.shine.entity.LanguageTranslation;
import com.mera.shine.mapper.LanguageTranslationMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the LanguageTranslationMapper interface.
 */
@Component
public class LanguageTranslationMapperImpl implements LanguageTranslationMapper {

    @Override
    public LanguageTranslationDto toDto(LanguageTranslation entity) {
        if (entity == null) {
            return null;
        }

        return new LanguageTranslationDto(
                entity.getId(),
                entity.getLangId(),
                entity.getLangKey(),
                entity.getLangValue()
        );
    }

    @Override
    public LanguageTranslation toEntity(LanguageTranslationDto dto) {
        if (dto == null) {
            return null;
        }

        LanguageTranslation languageTranslation = new LanguageTranslation();
        languageTranslation.setId(dto.id());
        languageTranslation.setLangId(dto.langId());
        languageTranslation.setLangKey(dto.langKey());
        languageTranslation.setLangValue(dto.langValue());

        return languageTranslation;
    }

    @Override
    public LanguageTranslation createDtoToEntity(CreateLanguageTranslationRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        LanguageTranslation languageTranslation = new LanguageTranslation();
        languageTranslation.setLangId(createDto.langId());
        languageTranslation.setLangKey(createDto.langKey());
        languageTranslation.setLangValue(createDto.langValue());

        return languageTranslation;
    }

    @Override
    public LanguageTranslation updateEntityFromDto(LanguageTranslationDto dto, LanguageTranslation entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setLangId(dto.langId());
        entity.setLangKey(dto.langKey());
        entity.setLangValue(dto.langValue());

        return entity;
    }
}