package com.mera.shine.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.mera.shine.entity.Currency}
 */
public record CurrencyDto(
    Integer id,
    String title,
    String code,
    String symbolLeft,
    String symbolRight,
    Character decimalPlace,
    BigDecimal value,
    Instant createdAt
) {
}