package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.SmsConfig}
 */
public record SmsConfigDto(
    Integer id,
    String senderId,
    String authKey,
    Integer contact,
    Integer societe
) {
}