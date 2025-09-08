package com.mera.shine.service;

import com.mera.shine.dto.request.CreateUniteMesureRequestDto;
import com.mera.shine.dto.response.UniteMesureDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing UniteMesure entities.
 */
public interface UniteMesureService {

    /**
     * Get all unites mesure.
     *
     * @return list of all unites mesure
     */
    List<UniteMesureDto> findAll();

    /**
     * Get a unite mesure by its ID.
     *
     * @param id the ID of the unite mesure
     * @return the unite mesure if found
     */
    Optional<UniteMesureDto> findById(Integer id);

    /**
     * Find unites mesure by société ID.
     *
     * @param societeId the société ID
     * @return list of unites mesure belonging to the société
     */
    List<UniteMesureDto> findBySocieteId(Integer societeId);





    /**
     * Create a new unite mesure.
     *
     * @param createUniteMesureDto the unite mesure to create
     * @return the created unite mesure
     */
    UniteMesureDto create(CreateUniteMesureRequestDto createUniteMesureDto);

    /**
     * Update an existing unite mesure.
     *
     * @param id the ID of the unite mesure to update
     * @param uniteMesureDto the updated unite mesure data
     * @return the updated unite mesure
     */
    UniteMesureDto update(Integer id, UniteMesureDto uniteMesureDto);

    /**
     * Delete a unite mesure by its ID.
     *
     * @param id the ID of the unite mesure to delete
     */
    void delete(Integer id);
}
