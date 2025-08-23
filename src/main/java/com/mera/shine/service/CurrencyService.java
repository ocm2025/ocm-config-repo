package com.mera.shine.service;

import com.mera.shine.dto.request.CreateCurrencyRequestDto;
import com.mera.shine.dto.response.CurrencyDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Currency entities.
 */
public interface CurrencyService {
    
    /**
     * Get all currencies.
     *
     * @return list of all currencies
     */
    List<CurrencyDto> findAll();
    
    /**
     * Get a currency by its ID.
     *
     * @param id the ID of the currency
     * @return the currency if found
     */
    Optional<CurrencyDto> findById(Integer id);
    
    /**
     * Create a new currency.
     *
     * @param createCurrencyDto the currency to create
     * @return the created currency
     */
    CurrencyDto create(CreateCurrencyRequestDto createCurrencyDto);
    
    /**
     * Update an existing currency.
     *
     * @param id the ID of the currency to update
     * @param currencyDto the updated currency data
     * @return the updated currency
     */
    CurrencyDto update(Integer id, CurrencyDto currencyDto);
    
    /**
     * Delete a currency by its ID.
     *
     * @param id the ID of the currency to delete
     */
    void delete(Integer id);
}