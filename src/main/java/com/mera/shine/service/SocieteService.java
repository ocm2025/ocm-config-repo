package com.mera.shine.service;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.SocieteDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Societe entities.
 */
public interface SocieteService {
    
    /**
     * Get all societes.
     *
     * @return list of all societes
     */
    List<SocieteDto> findAll();
    
    /**
     * Get a societe by its ID.
     *
     * @param id the ID of the societe
     * @return the societe if found
     */
    Optional<SocieteDto> findById(Integer id);
    

    /**
     * Create a new societe.
     *
     * @param createSocieteDto the societe to create
     * @return the created societe
     */
    SocieteDto create(CreateSocieteRequestDto createSocieteDto);
    
    /**
     * Update an existing societe.
     *
     * @param id the ID of the societe to update
     * @param societeDto the updated societe data
     * @return the updated societe
     */
    SocieteDto update(Integer id, SocieteDto societeDto);
    
    /**
     * Delete a societe by its ID.
     *
     * @param id the ID of the societe to delete
     */
    void delete(Integer id);
}