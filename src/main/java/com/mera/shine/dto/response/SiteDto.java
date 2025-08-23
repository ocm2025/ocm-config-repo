package com.mera.shine.dto.response;

import java.util.Set;

/**
 * DTO for {@link com.mera.shine.entity.Site}
 */
public record SiteDto(
    Integer id,
    String pvNom,
    String pvCode,
    String pvDescription,
    String pvVille,
    String pvPays,
    Short pvGetEmplacement,
    Integer societeId,
    Set<Integer> emplacementIds,
    Set<Integer> parametreIds
) {
}