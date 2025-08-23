package com.mera.shine.service;

import com.mera.shine.dto.request.CreateTiersToSiteRequestDto;
import com.mera.shine.dto.response.TiersToSiteDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing TiersToSite entities.
 */
public interface TiersToSiteService {
    
    /**
     * Get all tier to site mappings.
     *
     * @return list of all tier to site mappings
     */
    List<TiersToSiteDto> findAll();
    

    /**
     * Get a tier to site mapping by its ID.
     *
     * @param id the ID of the tier to site mapping
     * @return the tier to site mapping if found
     */
    Optional<TiersToSiteDto> findById(Integer id);
    

    /**
     * Create a new tier to site mapping.
     *
     * @param createTiersToSiteDto the tier to site mapping to create
     * @return the created tier to site mapping
     */
    TiersToSiteDto create(CreateTiersToSiteRequestDto createTiersToSiteDto);
    
    /**
     * Update an existing tier to site mapping.
     *
     * @param id the ID of the tier to site mapping to update
     * @param tiersToSiteDto the updated tier to site mapping data
     * @return the updated tier to site mapping
     */
    TiersToSiteDto update(Integer id, TiersToSiteDto tiersToSiteDto);
    
    /**
     * Delete a tier to site mapping by its ID.
     *
     * @param id the ID of the tier to site mapping to delete
     */
    void delete(Integer id);
}