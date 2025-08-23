package com.mera.shine.service;

import com.mera.shine.dto.request.CreateTaxeRequestDto;
import com.mera.shine.dto.response.TaxeDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Taxe entities.
 */
public interface TaxeService {
    
    /**
     * Get all taxes.
     *
     * @return list of all taxes
     */
    List<TaxeDto> findAll();


    /**
     * Get a tax by its ID.
     *
     * @param id the ID of the tax
     * @return the tax if found
     */
    Optional<TaxeDto> findById(Integer id);
    

    /**
     * Create a new tax.
     *
     * @param createTaxeDto the tax to create
     * @return the created tax
     */
    TaxeDto create(CreateTaxeRequestDto createTaxeDto);
    
    /**
     * Update an existing tax.
     *
     * @param id the ID of the tax to update
     * @param taxeDto the updated tax data
     * @return the updated tax
     */
    TaxeDto update(Integer id, TaxeDto taxeDto);
    
    /**
     * Delete a tax by its ID.
     *
     * @param id the ID of the tax to delete
     */
    void delete(Integer id);
}