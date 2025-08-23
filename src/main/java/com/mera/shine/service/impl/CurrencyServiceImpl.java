package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateCurrencyRequestDto;
import com.mera.shine.dto.response.CurrencyDto;
import com.mera.shine.entity.Currency;
import com.mera.shine.mapper.CurrencyMapper;
import com.mera.shine.repository.CurrencyRepository;
import com.mera.shine.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the CurrencyService interface.
 */
@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyDto> findAll() {
        return currencyRepository.findAll().stream()
                .map(currencyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CurrencyDto> findById(Integer id) {
        return currencyRepository.findById(id)
                .map(currencyMapper::toDto);
    }

    @Override
    @Transactional
    public CurrencyDto create(CreateCurrencyRequestDto createCurrencyDto) {
        Currency currency = currencyMapper.createDtoToEntity(createCurrencyDto);
        currency = currencyRepository.save(currency);
        return currencyMapper.toDto(currency);
    }

    @Override
    @Transactional
    public CurrencyDto update(Integer id, CurrencyDto currencyDto) {
        return currencyRepository.findById(id)
                .map(existingCurrency -> {
                    Currency updatedCurrency = currencyMapper.updateEntityFromDto(currencyDto, existingCurrency);
                    updatedCurrency = currencyRepository.save(updatedCurrency);
                    return currencyMapper.toDto(updatedCurrency);
                })
                .orElseThrow(() -> new RuntimeException("Currency not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        currencyRepository.deleteById(id);
    }
}