package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.EmailConfig}
 */
public record CreateEmailConfigRequestDto(
    @Size(max = 20)
    String host,
    
    @NotNull
    Integer port,
    
    @NotNull
    Byte auth,
    
    @NotNull
    @Size(max = 20)
    String authType,
    
    @NotNull
    @Size(max = 20)
    String username,
    
    @NotNull
    @Size(max = 20)
    String passwordTxt,
    
    @NotNull
    @Size(max = 20)
    String fromAdress,
    
    @Size(max = 50)
    String fromName,
    
    Integer societeId
) {
}