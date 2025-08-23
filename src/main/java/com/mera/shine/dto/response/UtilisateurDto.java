package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.Utilisateur}
 */
public record UtilisateurDto(
    Integer id,
    String uNomPrenom,
    String uTelephone,
    String uAdresse,
    String uUserName,
    String uEmail,
    Integer siteId,
    Integer societeId,
    Integer groupeId
) {
}