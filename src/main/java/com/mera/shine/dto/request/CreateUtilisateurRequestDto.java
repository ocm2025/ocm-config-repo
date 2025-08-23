package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Utilisateur}
 */
public record CreateUtilisateurRequestDto(
    @NotNull
    @Size(max = 255)
    String uNomPrenom,
    
    @Size(max = 255)
    String uTelephone,
    
    @Size(max = 255)
    String uAdresse,
    
    @NotNull
    @Size(max = 255)
    String uUserName,
    
    @NotNull
    @Size(max = 255)
    String uPassword,
    
    @Size(max = 255)
    String uEmail,
    
    @Size(max = 255)
    String uPwdText,
    
    Integer siteId,

    Integer groupeId,
    
    @NotNull
    Integer societeId
) {
}