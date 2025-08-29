package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.SmsConfig}
 */
public record CreateSmsConfigRequestDto(
    @Size(max = 20)
    String senderId,
    
    @Size(max = 20)
    String authKey,
    
    @NotNull
    Integer contact,
    
    Integer societe
) {
}