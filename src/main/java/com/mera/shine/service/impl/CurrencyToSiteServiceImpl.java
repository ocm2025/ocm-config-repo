package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateCurrencyToSiteRequestDto;
import com.mera.shine.dto.response.CurrencyToSiteDto;
import com.mera.shine.entity.CurrencyToSite;
import com.mera.shine.mapper.CurrencyToSiteMapper;
import com.mera.shine.repository.CurrencyToSiteRepository;
import com.mera.shine.service.CurrencyToSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the CurrencyToSiteService interface.
 */
@Service
@Transactional
public  class CurrencyToSiteServiceImpl implements CurrencyToSiteService {

    private final CurrencyToSiteRepository currencyToSiteRepository;
    private final CurrencyToSiteMapper currencyToSiteMapper;

    @Autowired
    public CurrencyToSiteServiceImpl(CurrencyToSiteRepository currencyToSiteRepository, CurrencyToSiteMapper currencyToSiteMapper) {
        this.currencyToSiteRepository = currencyToSiteRepository;
        this.currencyToSiteMapper = currencyToSiteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CurrencyToSiteDto> findAll() {
        return currencyToSiteRepository.findAll().stream()
                .map(currencyToSiteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CurrencyToSiteDto> findById(Integer id) {
        return currencyToSiteRepository.findById(id)
                .map(currencyToSiteMapper::toDto);
    }

    @Override
    @Transactional
    public CurrencyToSiteDto create(CreateCurrencyToSiteRequestDto createCurrencyToSiteDto) {
        CurrencyToSite currencyToSite = currencyToSiteMapper.createDtoToEntity(createCurrencyToSiteDto);
        currencyToSite = currencyToSiteRepository.save(currencyToSite);
        return currencyToSiteMapper.toDto(currencyToSite);
    }

    @Override
    @Transactional
    public CurrencyToSiteDto update(Integer id, CurrencyToSiteDto currencyToSiteDto) {
        return currencyToSiteRepository.findById(id)
                .map(existingCurrencyToSite -> {
                    CurrencyToSite updatedCurrencyToSite = currencyToSiteMapper.updateEntityFromDto(currencyToSiteDto, existingCurrencyToSite);
                    updatedCurrencyToSite = currencyToSiteRepository.save(updatedCurrencyToSite);
                    return currencyToSiteMapper.toDto(updatedCurrencyToSite);
                })
                .orElseThrow(() -> new RuntimeException("CurrencyToSite not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        currencyToSiteRepository.deleteById(id);
    }
}