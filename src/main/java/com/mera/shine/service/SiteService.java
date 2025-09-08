package com.mera.shine.service;

import com.mera.shine.dto.request.CreateSiteRequestDto;
import com.mera.shine.dto.response.SiteDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Site entities.
 */
public interface SiteService {

    /**
     * Get all sites.
     *
     * @return list of all sites
     */
    List<SiteDto> findAll();

    List<SiteDto> findBySociete(Integer societeId);
    /**
     * Get a site by its ID.
     *
     * @param id the ID of the site
     * @return the site if found
     */
    Optional<SiteDto> findById(Integer id);


    /**
     * Create a new site.
     *
     * @param createSiteDto the site to create
     * @return the created site
     */
    SiteDto create(CreateSiteRequestDto createSiteDto);

    /**
     * Update an existing site.
     *
     * @param id the ID of the site to update
     * @param siteDto the updated site data
     * @return the updated site
     */
    SiteDto update(Integer id, SiteDto siteDto);

    /**
     * Delete a site by its ID.
     *
     * @param id the ID of the site to delete
     */
    void delete(Integer id);
}
