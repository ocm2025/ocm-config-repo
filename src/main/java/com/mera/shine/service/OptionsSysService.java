package com.mera.shine.service;

import com.mera.shine.dto.request.CreateOptionsSysRequestDto;
import com.mera.shine.dto.response.OptionsSysDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing OptionsSys entities.
 */
public interface OptionsSysService {
    
    /**
     * Get all system options.
     *
     * @return list of all system options
     */
    List<OptionsSysDto> findAll();
    
    /**
     * Get a system option by its ID.
     *
     * @param id the ID of the system option
     * @return the system option if found
     */
    Optional<OptionsSysDto> findById(Integer id);
    

    /**
     * Create a new system option.
     *
     * @param createOptionsSysDto the system option to create
     * @return the created system option
     */
    OptionsSysDto create(CreateOptionsSysRequestDto createOptionsSysDto);
    
    /**
     * Update an existing system option.
     *
     * @param id the ID of the system option to update
     * @param optionsSysDto the updated system option data
     * @return the updated system option
     */
    OptionsSysDto update(Integer id, OptionsSysDto optionsSysDto);
    
    /**
     * Delete a system option by its ID.
     *
     * @param id the ID of the system option to delete
     */
    void delete(Integer id);
}