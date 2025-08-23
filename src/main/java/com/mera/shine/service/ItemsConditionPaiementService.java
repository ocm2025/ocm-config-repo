package com.mera.shine.service;

import com.mera.shine.dto.request.CreateItemsConditionPaiementRequestDto;
import com.mera.shine.dto.response.ItemsConditionPaiementDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing ItemsConditionPaiement entities.
 */
public interface ItemsConditionPaiementService {
    
    /**
     * Get all items condition paiement.
     *
     * @return list of all items condition paiement
     */
    List<ItemsConditionPaiementDto> findAll();
    

    /**
     * Get an item by its ID.
     *
     * @param id the ID of the item
     * @return the item if found
     */
    Optional<ItemsConditionPaiementDto> findById(Integer id);
    
    /**
     * Create a new item.
     *
     * @param createItemsConditionPaiementDto the item to create
     * @return the created item
     */
    ItemsConditionPaiementDto create(CreateItemsConditionPaiementRequestDto createItemsConditionPaiementDto);
    
    /**
     * Update an existing item.
     *
     * @param id the ID of the item to update
     * @param itemsConditionPaiementDto the updated item data
     * @return the updated item
     */
    ItemsConditionPaiementDto update(Integer id, ItemsConditionPaiementDto itemsConditionPaiementDto);
    
    /**
     * Delete an item by its ID.
     *
     * @param id the ID of the item to delete
     */
    void delete(Integer id);
}