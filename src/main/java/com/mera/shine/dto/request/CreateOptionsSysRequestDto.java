package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.OptionsSys}
 */
public record CreateOptionsSysRequestDto(
    @NotNull
    @Size(max = 12)
    String osCode,
    
    @Size(max = 255)
    String osLibelle,
    
    @Size(max = 255)
    String osMessage
) {
}