package com.mera.shine.service;

import com.mera.shine.dto.request.CreateModePaiementRequestDto;
import com.mera.shine.dto.response.ModePaiementDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing ModePaiement entities.
 */
public interface ModePaiementService {
    
    /**
     * Get all payment methods.
     *
     * @return list of all payment methods
     */
    List<ModePaiementDto> findAll();

    /**
     * Get a payment method by its ID.
     *
     * @param id the ID of the payment method
     * @return the payment method if found
     */
    Optional<ModePaiementDto> findById(Integer id);
    
    /**
     * Create a new payment method.
     *
     * @param createModePaiementDto the payment method to create
     * @return the created payment method
     */
    ModePaiementDto create(CreateModePaiementRequestDto createModePaiementDto);
    
    /**
     * Update an existing payment method.
     *
     * @param id the ID of the payment method to update
     * @param modePaiementDto the updated payment method data
     * @return the updated payment method
     */
    ModePaiementDto update(Integer id, ModePaiementDto modePaiementDto);
    
    /**
     * Delete a payment method by its ID.
     *
     * @param id the ID of the payment method to delete
     */
    void delete(Integer id);
}