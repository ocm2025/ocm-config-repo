package com.mera.shine.service;

import com.mera.shine.dto.request.CreateParametreRequestDto;
import com.mera.shine.dto.response.ParametreDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Parametre entities.
 */
public interface ParametreService {

    /**
     * Get all parameters.
     *
     * @return list of all parameters
     */
    List<ParametreDto> findAll();

    /**
     * Get a parameter by its ID.
     *
     * @param id the ID of the parameter
     * @return the parameter if found
     */
    Optional<ParametreDto> findById(Integer id);

    /**
     * Find parameters by société ID.
     *
     * @param societeId the société ID
     * @return list of parameters belonging to the société
     */
    List<ParametreDto> findBysocieteId(Integer societeId);


    /**
     * Create a new parameter.
     *
     * @param createParametreDto the parameter to create
     * @return the created parameter
     */
    ParametreDto create(CreateParametreRequestDto createParametreDto);

    /**
     * Update an existing parameter.
     *
     * @param id the ID of the parameter to update
     * @param parametreDto the updated parameter data
     * @return the updated parameter
     */
    ParametreDto update(Integer id, ParametreDto parametreDto);

    /**
     * Delete a parameter by its ID.
     *
     * @param id the ID of the parameter to delete
     */
    void delete(Integer id);
}
