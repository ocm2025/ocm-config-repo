package com.mera.shine.dto.request;

import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.LoginLog}
 */
public record CreateLoginLogRequestDto(
    Integer userId,
    
    @Size(max = 100)
    String username,
    
    @Size(max = 50)
    String ip
) {
}