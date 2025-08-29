package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.EmailConfig}
 */
public record EmailConfigDto(
    Integer id,
    String host,
    Integer port,
    Byte auth,
    String authType,
    String username,
    String passwordTxt,
    String fromAdress,
    String fromName,
    Integer societeId
) {
}