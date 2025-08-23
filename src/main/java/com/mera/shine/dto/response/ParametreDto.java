package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Parametre}
 */
public record ParametreDto(
    Integer id,
    String csCode,
    String csLibelle,
    Byte csIsValid,
    String message,
    Integer societeId,
    Integer siteId
) {
}