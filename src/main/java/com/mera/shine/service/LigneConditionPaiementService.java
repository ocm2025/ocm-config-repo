package com.mera.shine.service;

import com.mera.shine.dto.request.CreateLigneConditionPaiementRequestDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing LigneConditionPaiement entities.
 */
public interface LigneConditionPaiementService {

    /**
     * Get all lignes condition paiement.
     *
     * @return list of all lignes condition paiement
     */
    List<LigneConditionPaiementDto> findAll();


    /**
     * Get a ligne condition paiement by its ID.
     *
     * @param id the ID of the ligne condition paiement
     * @return the ligne condition paiement if found
     */
    Optional<LigneConditionPaiementDto> findById(Integer id);

    /**
     * Find lignes condition paiement by société ID.
     *
     * @param societeId the société ID
     * @return list of lignes condition paiement belonging to the société
     */
    List<LigneConditionPaiementDto> findBySocieteId(Integer societeId);


    /**
     * Create a new ligne condition paiement.
     *
     * @param createLigneConditionPaiementDto the ligne condition paiement to create
     * @return the created ligne condition paiement
     */
    LigneConditionPaiementDto create(CreateLigneConditionPaiementRequestDto createLigneConditionPaiementDto);

    /**
     * Update an existing ligne condition paiement.
     *
     * @param id the ID of the ligne condition paiement to update
     * @param ligneConditionPaiementDto the updated ligne condition paiement data
     * @return the updated ligne condition paiement
     */
    LigneConditionPaiementDto update(Integer id, LigneConditionPaiementDto ligneConditionPaiementDto);

    /**
     * Delete a ligne condition paiement by its ID.
     *
     * @param id the ID of the ligne condition paiement to delete
     */
    void delete(Integer id);
}
