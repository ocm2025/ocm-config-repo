package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateLanguageTranslationRequestDto;
import com.mera.shine.dto.response.LanguageTranslationDto;
import com.mera.shine.entity.LanguageTranslation;

/**
 * Mapper for the LanguageTranslation entity and its DTOs.
 */
public interface LanguageTranslationMapper extends EntityMapper<LanguageTranslation, LanguageTranslationDto, CreateLanguageTranslationRequestDto> {
}