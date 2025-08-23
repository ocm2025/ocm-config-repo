package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Language}
 */
public record LanguageDto(
    Integer id,
    String name,
    String slug,
    String code
) {
}