package com.mera.shine.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * DTO for creating {@link com.mera.shine.entity.Currency}
 */
public record CreateCurrencyRequestDto(
    @NotNull
    @Size(max = 255)
    String title,
    
    @NotNull
    @Size(max = 255)
    String code,
    
    @NotNull
    @Size(max = 255)
    String symbolLeft,
    
    @NotNull
    @Size(max = 255)
    String symbolRight,
    
    @NotNull
    Character decimalPlace,
    
    @NotNull
    BigDecimal value
) {
}