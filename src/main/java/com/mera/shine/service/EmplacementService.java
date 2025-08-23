package com.mera.shine.service;

import com.mera.shine.dto.request.CreateEmplacementRequestDto;
import com.mera.shine.dto.response.EmplacementDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Emplacement entities.
 */
public interface EmplacementService {
    
    /**
     * Get all emplacements.
     *
     * @return list of all emplacements
     */
    List<EmplacementDto> findAll();
    

    /**
     * Get an emplacement by its ID.
     *
     * @param id the ID of the emplacement
     * @return the emplacement if found
     */
    Optional<EmplacementDto> findById(Integer id);
    

    /**
     * Create a new emplacement.
     *
     * @param createEmplacementDto the emplacement to create
     * @return the created emplacement
     */
    EmplacementDto create(CreateEmplacementRequestDto createEmplacementDto);
    
    /**
     * Update an existing emplacement.
     *
     * @param id the ID of the emplacement to update
     * @param emplacementDto the updated emplacement data
     * @return the updated emplacement
     */
    EmplacementDto update(Integer id, EmplacementDto emplacementDto);
    
    /**
     * Delete an emplacement by its ID.
     *
     * @param id the ID of the emplacement to delete
     */
    void delete(Integer id);
}