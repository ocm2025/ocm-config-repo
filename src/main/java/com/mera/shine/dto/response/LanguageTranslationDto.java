package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.LanguageTranslation}
 */
public record LanguageTranslationDto(
    Integer id,
    Integer langId,
    String langKey,
    String langValue
) {
}