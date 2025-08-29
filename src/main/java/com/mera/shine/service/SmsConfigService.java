package com.mera.shine.service;

import com.mera.shine.dto.request.CreateSmsConfigRequestDto;
import com.mera.shine.dto.response.SmsConfigDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing SmsConfig entities.
 */
public interface SmsConfigService {
    
    /**
     * Get all SMS configurations.
     *
     * @return list of all SMS configurations
     */
    List<SmsConfigDto> findAll();
    
    /**
     * Get an SMS configuration by its ID.
     *
     * @param id the ID of the SMS configuration
     * @return the SMS configuration if found
     */
    Optional<SmsConfigDto> findById(Integer id);
    

    /**
     * Create a new SMS configuration.
     *
     * @param createSmsConfigDto the SMS configuration to create
     * @return the created SMS configuration
     */
    SmsConfigDto create(CreateSmsConfigRequestDto createSmsConfigDto);
    
    /**
     * Update an existing SMS configuration.
     *
     * @param id the ID of the SMS configuration to update
     * @param smsConfigDto the updated SMS configuration data
     * @return the updated SMS configuration
     */
    SmsConfigDto update(Integer id, SmsConfigDto smsConfigDto);
    
    /**
     * Delete an SMS configuration by its ID.
     *
     * @param id the ID of the SMS configuration to delete
     */
    void delete(Integer id);
}