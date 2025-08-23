package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateCurrencyRequestDto;
import com.mera.shine.dto.response.CurrencyDto;
import com.mera.shine.entity.Currency;

/**
 * Mapper for the Currency entity and its DTOs.
 */
public interface CurrencyMapper extends EntityMapper<Currency, CurrencyDto, CreateCurrencyRequestDto> {
}