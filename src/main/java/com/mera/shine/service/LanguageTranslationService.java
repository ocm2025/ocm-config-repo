package com.mera.shine.service;

import com.mera.shine.dto.request.CreateLanguageTranslationRequestDto;
import com.mera.shine.dto.response.LanguageTranslationDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing LanguageTranslation entities.
 */
public interface LanguageTranslationService {
    
    /**
     * Get all language translations.
     *
     * @return list of all language translations
     */
    List<LanguageTranslationDto> findAll();
    

    /**
     * Get a translation by its ID.
     *
     * @param id the ID of the translation
     * @return the translation if found
     */
    Optional<LanguageTranslationDto> findById(Integer id);
    
    /**
     * Create a new translation.
     *
     * @param createLanguageTranslationDto the translation to create
     * @return the created translation
     */
    LanguageTranslationDto create(CreateLanguageTranslationRequestDto createLanguageTranslationDto);
    
    /**
     * Update an existing translation.
     *
     * @param id the ID of the translation to update
     * @param languageTranslationDto the updated translation data
     * @return the updated translation
     */
    LanguageTranslationDto update(Integer id, LanguageTranslationDto languageTranslationDto);
    
    /**
     * Delete a translation by its ID.
     *
     * @param id the ID of the translation to delete
     */
    void delete(Integer id);
}