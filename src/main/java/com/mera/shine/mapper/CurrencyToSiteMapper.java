package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateCurrencyToSiteRequestDto;
import com.mera.shine.dto.response.CurrencyToSiteDto;
import com.mera.shine.entity.CurrencyToSite;

/**
 * Mapper for the CurrencyToSite entity and its DTOs.
 */
public interface CurrencyToSiteMapper extends EntityMapper<CurrencyToSite, CurrencyToSiteDto, CreateCurrencyToSiteRequestDto> {
}