package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateLanguageRequestDto;
import com.mera.shine.dto.response.LanguageDto;
import com.mera.shine.entity.Language;

/**
 * Mapper for the Language entity and its DTOs.
 */
public interface LanguageMapper extends EntityMapper<Language, LanguageDto, CreateLanguageRequestDto> {
}