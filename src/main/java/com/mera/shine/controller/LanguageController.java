package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateLanguageRequestDto;
import com.mera.shine.dto.response.LanguageDto;
import com.mera.shine.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Language entities.
 */
@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * GET /api/languages : Get all languages.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of languages in body
     */
    @GetMapping
    public ResponseEntity<List<LanguageDto>> getAllLanguages() {
        List<LanguageDto> languages = languageService.findAll();
        return ResponseEntity.ok(languages);
    }

    /**
     * GET /api/languages/{id} : Get the "id" language.
     *
     * @param id the id of the language to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the language, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LanguageDto> getLanguage(@PathVariable Integer id) {
        return languageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/languages : Create a new language.
     *
     * @param createLanguageDto the language to create
     * @return the ResponseEntity with status 201 (Created) and with body the new language
     */
    @PostMapping
    public ResponseEntity<LanguageDto> createLanguage(@RequestBody CreateLanguageRequestDto createLanguageDto) {
        LanguageDto result = languageService.create(createLanguageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/languages/{id} : Updates an existing language.
     *
     * @param id the id of the language to update
     * @param languageDto the language to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated language,
     * or with status 404 (Not Found) if the language is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<LanguageDto> updateLanguage(
            @PathVariable Integer id,
            @RequestBody LanguageDto languageDto) {
        try {
            LanguageDto result = languageService.update(id, languageDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/languages/{id} : Delete the "id" language.
     *
     * @param id the id of the language to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Integer id) {
        languageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}