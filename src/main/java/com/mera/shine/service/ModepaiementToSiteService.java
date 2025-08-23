package com.mera.shine.service;

import com.mera.shine.dto.request.CreateModepaiementToSiteRequestDto;
import com.mera.shine.dto.response.ModepaiementToSiteDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing ModepaiementToSite entities.
 */
public interface ModepaiementToSiteService {
    
    /**
     * Get all payment method to site associations.
     *
     * @return list of all payment method to site associations
     */
    List<ModepaiementToSiteDto> findAll();

    /**
     * Get a payment method to site association by its ID.
     *
     * @param id the ID of the payment method to site association
     * @return the payment method to site association if found
     */
    Optional<ModepaiementToSiteDto> findById(Integer id);
    

    /**
     * Create a new payment method to site association.
     *
     * @param createModepaiementToSiteDto the payment method to site association to create
     * @return the created payment method to site association
     */
    ModepaiementToSiteDto create(CreateModepaiementToSiteRequestDto createModepaiementToSiteDto);
    
    /**
     * Update an existing payment method to site association.
     *
     * @param id the ID of the payment method to site association to update
     * @param modepaiementToSiteDto the updated payment method to site association data
     * @return the updated payment method to site association
     */
    ModepaiementToSiteDto update(Integer id, ModepaiementToSiteDto modepaiementToSiteDto);
    
    /**
     * Delete a payment method to site association by its ID.
     *
     * @param id the ID of the payment method to site association to delete
     */
    void delete(Integer id);
}