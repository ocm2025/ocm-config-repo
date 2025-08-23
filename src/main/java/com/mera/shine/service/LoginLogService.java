package com.mera.shine.service;

import com.mera.shine.dto.request.CreateLoginLogRequestDto;
import com.mera.shine.dto.response.LoginLogDto;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing LoginLog entities.
 */
public interface LoginLogService {
    
    /**
     * Get all login logs.
     *
     * @return list of all login logs
     */
    List<LoginLogDto> findAll();

    /**
     * Get a login log by its ID.
     *
     * @param id the ID of the login log
     * @return the login log if found
     */
    Optional<LoginLogDto> findById(Integer id);
    
    /**
     * Create a new login log.
     *
     * @param createLoginLogDto the login log to create
     * @return the created login log
     */
    LoginLogDto create(CreateLoginLogRequestDto createLoginLogDto);
    
    /**
     * Update an existing login log.
     *
     * @param id the ID of the login log to update
     * @param loginLogDto the updated login log data
     * @return the updated login log
     */
    LoginLogDto update(Integer id, LoginLogDto loginLogDto);
    
    /**
     * Delete a login log by its ID.
     *
     * @param id the ID of the login log to delete
     */
    void delete(Integer id);
}