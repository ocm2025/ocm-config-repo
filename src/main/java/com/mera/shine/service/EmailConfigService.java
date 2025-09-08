package com.mera.shine.service;

import com.mera.shine.dto.request.CreateEmailConfigRequestDto;
import com.mera.shine.dto.response.EmailConfigDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing EmailConfig entities.
 */
public interface EmailConfigService {

    /**
     * Get all email configurations.
     *
     * @return list of all email configurations
     */
    List<EmailConfigDto> findAll();

    /**
     * Get an email configuration by its ID.
     *
     * @param id the ID of the email configuration
     * @return the email configuration if found
     */
    Optional<EmailConfigDto> findById(Integer id);

    /**
     * Find email configuration by société ID.
     *
     * @param societeId the société ID
     * @return the email configuration for the société
     */
    EmailConfigDto findBySocieteId(Integer societeId);


    /**
     * Create a new email configuration.
     *
     * @param createEmailConfigDto the email configuration to create
     * @return the created email configuration
     */
    EmailConfigDto create(CreateEmailConfigRequestDto createEmailConfigDto);

    /**
     * Update an existing email configuration.
     *
     * @param id the ID of the email configuration to update
     * @param emailConfigDto the updated email configuration data
     * @return the updated email configuration
     */
    EmailConfigDto update(Integer id, EmailConfigDto emailConfigDto);

    /**
     * Delete an email configuration by its ID.
     *
     * @param id the ID of the email configuration to delete
     */
    void delete(Integer id);
}
