package com.mera.shine.dto.response;

import java.util.Set;

/**
 * DTO for {@link com.mera.shine.entity.Societe}
 */
public record SocieteDto(
    Integer id,
    String sNom,
    String sActivite,
    String sAdresse,
    String sBoitePostal,
    String sPays,
    String sRegion,
    String sTelephone,
    String sNc,
    String sRccm,
    String sRegimeFiscal,
    String sDevise,
    String sLogo,
    String sFovicon,
    Set<Integer> parametreIds
) {
}