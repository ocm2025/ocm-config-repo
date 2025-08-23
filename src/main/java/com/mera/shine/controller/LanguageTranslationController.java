package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateLanguageTranslationRequestDto;
import com.mera.shine.dto.response.LanguageTranslationDto;
import com.mera.shine.service.LanguageTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing LanguageTranslation entities.
 */
@RestController
@RequestMapping("/api/language-translations")
public class LanguageTranslationController {

    private final LanguageTranslationService languageTranslationService;

    @Autowired
    public LanguageTranslationController(LanguageTranslationService languageTranslationService) {
        this.languageTranslationService = languageTranslationService;
    }

    /**
     * GET /api/language-translations : Get all language translations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of language translations in body
     */
    @GetMapping
    public ResponseEntity<List<LanguageTranslationDto>> getAllLanguageTranslations() {
        List<LanguageTranslationDto> languageTranslations = languageTranslationService.findAll();
        return ResponseEntity.ok(languageTranslations);
    }

    /**
     * GET /api/language-translations/{id} : Get the "id" language translation.
     *
     * @param id the id of the language translation to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the language translation, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LanguageTranslationDto> getLanguageTranslation(@PathVariable Integer id) {
        return languageTranslationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/language-translations : Create a new language translation.
     *
     * @param createLanguageTranslationDto the language translation to create
     * @return the ResponseEntity with status 201 (Created) and with body the new language translation
     */
    @PostMapping
    public ResponseEntity<LanguageTranslationDto> createLanguageTranslation(@RequestBody CreateLanguageTranslationRequestDto createLanguageTranslationDto) {
        LanguageTranslationDto result = languageTranslationService.create(createLanguageTranslationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/language-translations/{id} : Updates an existing language translation.
     *
     * @param id the id of the language translation to update
     * @param languageTranslationDto the language translation to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated language translation,
     * or with status 404 (Not Found) if the language translation is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<LanguageTranslationDto> updateLanguageTranslation(
            @PathVariable Integer id,
            @RequestBody LanguageTranslationDto languageTranslationDto) {
        try {
            LanguageTranslationDto result = languageTranslationService.update(id, languageTranslationDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/language-translations/{id} : Delete the "id" language translation.
     *
     * @param id the id of the language translation to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguageTranslation(@PathVariable Integer id) {
        languageTranslationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
