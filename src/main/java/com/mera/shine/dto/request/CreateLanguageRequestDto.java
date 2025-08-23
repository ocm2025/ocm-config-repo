package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO for creating {@link com.mera.shine.entity.Language}
 */
public record CreateLanguageRequestDto(
    @NotNull
    @Size(max = 100)
    String name,
    
    @NotNull
    @Size(max = 50)
    String slug,
    
    @Size(max = 10)
    String code
) {
}