package com.mera.shine.service;

import com.mera.shine.dto.request.CreateCurrencyToSiteRequestDto;
import com.mera.shine.dto.response.CurrencyToSiteDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing CurrencyToSite entities.
 */
public interface CurrencyToSiteService {
    
    /**
     * Get all currency to site mappings.
     *
     * @return list of all currency to site mappings
     */
    List<CurrencyToSiteDto> findAll();
    

    /**
     * Get a currency to site mapping by its ID.
     *
     * @param id the ID of the currency to site mapping
     * @return the currency to site mapping if found
     */
    Optional<CurrencyToSiteDto> findById(Integer id);
    
    /**
     * Create a new currency to site mapping.
     *
     * @param createCurrencyToSiteDto the currency to site mapping to create
     * @return the created currency to site mapping
     */
    CurrencyToSiteDto create(CreateCurrencyToSiteRequestDto createCurrencyToSiteDto);
    
    /**
     * Update an existing currency to site mapping.
     *
     * @param id the ID of the currency to site mapping to update
     * @param currencyToSiteDto the updated currency to site mapping data
     * @return the updated currency to site mapping
     */
    CurrencyToSiteDto update(Integer id, CurrencyToSiteDto currencyToSiteDto);
    
    /**
     * Delete a currency to site mapping by its ID.
     *
     * @param id the ID of the currency to site mapping to delete
     */
    void delete(Integer id);
}