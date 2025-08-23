package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.UniteMesure}
 */
public record UniteMesureDto(
    Integer id,
    String umCode,
    String umLibelle,
    Integer umIsReference,
    Integer societeId
) {
}