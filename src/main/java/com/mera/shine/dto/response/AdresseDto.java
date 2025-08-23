package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Adresse}
 */
public record AdresseDto(
    Integer id,
    Short afType,
    String afRue,
    String afVille,
    String afPays,
    String afCodePostal,
    Integer tiersId
) {
}