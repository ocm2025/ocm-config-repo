package com.mera.shine.service;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.response.AdresseDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Adresse entities.
 */
public interface AdresseService {

    /**
     * Get all addresses.
     *
     * @return list of all addresses
     */
    List<AdresseDto> findAll();


    /**
     * Get an address by its ID.
     *
     * @param id the ID of the address
     * @return the address if found
     */
    Optional<AdresseDto> findById(Integer id);

    /**
     * Find addresses by tiers ID.
     *
     * @param tiersId the tiers ID
     * @return list of addresses belonging to the tiers
     */
    List<AdresseDto> findByTiersId(Integer tiersId);

    /**
     * Create a new address.
     *
     * @param createAdresseDto the address to create
     * @return the created address
     */
    AdresseDto create(CreateAdresseRequestDto createAdresseDto);

    /**
     * Update an existing address.
     *
     * @param id the ID of the address to update
     * @param adresseDto the updated address data
     * @return the updated address
     */
    AdresseDto update(Integer id, AdresseDto adresseDto);

    /**
     * Delete an address by its ID.
     *
     * @param id the ID of the address to delete
     */
    void delete(Integer id);
}
