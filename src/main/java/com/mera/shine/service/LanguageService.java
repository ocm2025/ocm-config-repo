package com.mera.shine.service;

import com.mera.shine.dto.request.CreateLanguageRequestDto;
import com.mera.shine.dto.response.LanguageDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Language entities.
 */
public interface LanguageService {
    
    /**
     * Get all languages.
     *
     * @return list of all languages
     */
    List<LanguageDto> findAll();
    
    /**
     * Get a language by its ID.
     *
     * @param id the ID of the language
     * @return the language if found
     */
    Optional<LanguageDto> findById(Integer id);

    /**
     * Create a new language.
     *
     * @param createLanguageDto the language to create
     * @return the created language
     */
    LanguageDto create(CreateLanguageRequestDto createLanguageDto);
    
    /**
     * Update an existing language.
     *
     * @param id the ID of the language to update
     * @param languageDto the updated language data
     * @return the updated language
     */
    LanguageDto update(Integer id, LanguageDto languageDto);
    
    /**
     * Delete a language by its ID.
     *
     * @param id the ID of the language to delete
     */
    void delete(Integer id);
}