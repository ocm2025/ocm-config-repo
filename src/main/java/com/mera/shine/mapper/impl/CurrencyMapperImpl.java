package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateCurrencyRequestDto;
import com.mera.shine.dto.response.CurrencyDto;
import com.mera.shine.entity.Currency;
import com.mera.shine.mapper.CurrencyMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * Implementation of the CurrencyMapper interface.
 */
@Component
public class CurrencyMapperImpl implements CurrencyMapper {

    @Override
    public CurrencyDto toDto(Currency entity) {
        if (entity == null) {
            return null;
        }

        return new CurrencyDto(
                entity.getId(),
                entity.getTitle(),
                entity.getCode(),
                entity.getSymbolLeft(),
                entity.getSymbolRight(),
                entity.getDecimalPlace(),
                entity.getValue(),
                entity.getCreatedAt()
        );
    }

    @Override
    public Currency toEntity(CurrencyDto dto) {
        if (dto == null) {
            return null;
        }

        Currency currency = new Currency();
        currency.setId(dto.id());
        currency.setTitle(dto.title());
        currency.setCode(dto.code());
        currency.setSymbolLeft(dto.symbolLeft());
        currency.setSymbolRight(dto.symbolRight());
        currency.setDecimalPlace(dto.decimalPlace());
        currency.setValue(dto.value());
        currency.setCreatedAt(dto.createdAt());

        return currency;
    }

    @Override
    public Currency createDtoToEntity(CreateCurrencyRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Currency currency = new Currency();
        currency.setTitle(createDto.title());
        currency.setCode(createDto.code());
        currency.setSymbolLeft(createDto.symbolLeft());
        currency.setSymbolRight(createDto.symbolRight());
        currency.setDecimalPlace(createDto.decimalPlace());
        currency.setValue(createDto.value());
        currency.setCreatedAt(Instant.now()); // Set current time for new entities

        return currency;
    }

    @Override
    public Currency updateEntityFromDto(CurrencyDto dto, Currency entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setTitle(dto.title());
        entity.setCode(dto.code());
        entity.setSymbolLeft(dto.symbolLeft());
        entity.setSymbolRight(dto.symbolRight());
        entity.setDecimalPlace(dto.decimalPlace());
        entity.setValue(dto.value());
        // We don't update createdAt as it should remain the original creation time

        return entity;
    }
}