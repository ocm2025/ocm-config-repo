package com.mera.shine.service;

import com.mera.shine.dto.request.CreateZoneDistributionRequestDto;
import com.mera.shine.dto.response.ZoneDistributionDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing ZoneDistribution entities.
 */
public interface ZoneDistributionService {
    
    /**
     * Get all zone distributions.
     *
     * @return list of all zone distributions
     */
    List<ZoneDistributionDto> findAll();
    

    /**
     * Get a zone distribution by its ID.
     *
     * @param id the ID of the zone distribution
     * @return the zone distribution if found
     */
    Optional<ZoneDistributionDto> findById(Integer id);


    /**
     * Create a new zone distribution.
     *
     * @param createZoneDistributionDto the zone distribution to create
     * @return the created zone distribution
     */
    ZoneDistributionDto create(CreateZoneDistributionRequestDto createZoneDistributionDto);
    
    /**
     * Update an existing zone distribution.
     *
     * @param id the ID of the zone distribution to update
     * @param zoneDistributionDto the updated zone distribution data
     * @return the updated zone distribution
     */
    ZoneDistributionDto update(Integer id, ZoneDistributionDto zoneDistributionDto);
    
    /**
     * Delete a zone distribution by its ID.
     *
     * @param id the ID of the zone distribution to delete
     */
    void delete(Integer id);
}