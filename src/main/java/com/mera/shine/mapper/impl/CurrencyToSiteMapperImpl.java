package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateCurrencyToSiteRequestDto;
import com.mera.shine.dto.response.CurrencyToSiteDto;
import com.mera.shine.entity.Currency;
import com.mera.shine.entity.CurrencyToSite;
import com.mera.shine.entity.Site;
import com.mera.shine.mapper.CurrencyToSiteMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the CurrencyToSiteMapper interface.
 */
@Component
public class CurrencyToSiteMapperImpl implements CurrencyToSiteMapper {

    @Override
    public CurrencyToSiteDto toDto(CurrencyToSite entity) {
        if (entity == null) {
            return null;
        }

        Integer currencyId = null;
        if (entity.getCurrency() != null) {
            currencyId = entity.getCurrency().getId();
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        return new CurrencyToSiteDto(
                entity.getId(),
                currencyId,
                siteId,
                entity.getStatus()
        );
    }

    @Override
    public CurrencyToSite toEntity(CurrencyToSiteDto dto) {
        if (dto == null) {
            return null;
        }

        CurrencyToSite currencyToSite = new CurrencyToSite();
        currencyToSite.setId(dto.id());
        currencyToSite.setStatus(dto.status());

        if (dto.currencyId() != null) {
            Currency currency = new Currency();
            currency.setId(dto.currencyId());
            currencyToSite.setCurrency(currency);
        }

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            currencyToSite.setSite(site);
        }

        return currencyToSite;
    }

    @Override
    public CurrencyToSite createDtoToEntity(CreateCurrencyToSiteRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        CurrencyToSite currencyToSite = new CurrencyToSite();
        currencyToSite.setStatus(createDto.status());

        if (createDto.currencyId() != null) {
            Currency currency = new Currency();
            currency.setId(createDto.currencyId());
            currencyToSite.setCurrency(currency);
        }

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            currencyToSite.setSite(site);
        }

        return currencyToSite;
    }

    @Override
    public CurrencyToSite updateEntityFromDto(CurrencyToSiteDto dto, CurrencyToSite entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setStatus(dto.status());

        if (dto.currencyId() != null) {
            if (entity.getCurrency() == null || !entity.getCurrency().getId().equals(dto.currencyId())) {
                Currency currency = new Currency();
                currency.setId(dto.currencyId());
                entity.setCurrency(currency);
            }
        } else {
            entity.setCurrency(null);
        }

        if (dto.siteId() != null) {
            if (entity.getSite() == null || !entity.getSite().getId().equals(dto.siteId())) {
                Site site = new Site();
                site.setId(dto.siteId());
                entity.setSite(site);
            }
        } else {
            entity.setSite(null);
        }

        return entity;
    }
}