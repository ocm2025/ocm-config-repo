package com.mera.shine.service;

import com.mera.shine.dto.request.CreateTierRequestDto;
import com.mera.shine.dto.response.TierDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Tier entities.
 */
public interface TierService {

    /**
     * Get all tiers.
     *
     * @return list of all tiers
     */
    List<TierDto> findAll();


    /**
     * Get a tier by its ID.
     *
     * @param id the ID of the tier
     * @return the tier if found
     */
    Optional<TierDto> findById(Integer id);

    /**
     * Find tiers by client type and société ID.
     *
     * @param clType the client type
     * @param societeId the société ID
     * @return list of tiers matching the criteria
     */
    List<TierDto> findByClTypeAndSocieteId(Integer clType, Integer societeId);

    /**
     * Find tiers by client type and site ID.
     *
     * @param clType the client type
     * @param siteId the site ID
     * @return list of tiers matching the criteria
     */
    List<TierDto> findByClTypeAndSiteId(Integer clType, Integer siteId);

    /**
     * Create a new tier.
     *
     * @param createTierDto the tier to create
     * @return the created tier
     */
    TierDto create(CreateTierRequestDto createTierDto);

    /**
     * Update an existing tier.
     *
     * @param id the ID of the tier to update
     * @param tierDto the updated tier data
     * @return the updated tier
     */
    TierDto update(Integer id, TierDto tierDto);

    /**
     * Delete a tier by its ID.
     *
     * @param id the ID of the tier to delete
     */
    void delete(Integer id);
}
