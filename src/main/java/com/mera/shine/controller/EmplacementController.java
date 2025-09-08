package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateEmplacementRequestDto;
import com.mera.shine.dto.response.EmplacementDto;
import com.mera.shine.service.EmplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Emplacement entities.
 */
@RestController
@RequestMapping("/api/emplacements")
public class EmplacementController {

    private final EmplacementService emplacementService;

    @Autowired
    public EmplacementController(EmplacementService emplacementService) {
        this.emplacementService = emplacementService;
    }

    /**
     * GET /api/emplacements : Get all emplacements.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of emplacements in body
     */
    @GetMapping
    public ResponseEntity<List<EmplacementDto>> getAllEmplacements() {
        List<EmplacementDto> emplacements = emplacementService.findAll();
        return ResponseEntity.ok(emplacements);
    }


    /**
     * GET /api/emplacements/{id} : Get the "id" emplacement.
     *
     * @param id the id of the emplacement to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the emplacement, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmplacementDto> getEmplacement(@PathVariable Integer id) {
        return emplacementService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/bysociete/{societeId}")
    public ResponseEntity<List<EmplacementDto>> getEmplacementBySociete(@PathVariable Integer societeId) {
        List<EmplacementDto> emplacementDtos = emplacementService.findBySocieteId(societeId);
         return ResponseEntity.ok(emplacementDtos);
    }

    @GetMapping("/bysite/{siteId}")
    public ResponseEntity<List<EmplacementDto>> getEmplacementBySite(@PathVariable Integer siteId) {
        List<EmplacementDto> emplacementDtos = emplacementService.findBySocieteId(siteId);
        return ResponseEntity.ok(emplacementDtos);
    }


    /**
     * POST /api/emplacements : Create a new emplacement.
     *
     * @param createEmplacementDto the emplacement to create
     * @return the ResponseEntity with status 201 (Created) and with body the new emplacement
     */
    @PostMapping
    public ResponseEntity<EmplacementDto> createEmplacement(@RequestBody CreateEmplacementRequestDto createEmplacementDto) {
        EmplacementDto result = emplacementService.create(createEmplacementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/emplacements/{id} : Updates an existing emplacement.
     *
     * @param id the id of the emplacement to update
     * @param emplacementDto the emplacement to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated emplacement,
     * or with status 404 (Not Found) if the emplacement is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmplacementDto> updateEmplacement(
            @PathVariable Integer id,
            @RequestBody EmplacementDto emplacementDto) {
        try {
            EmplacementDto result = emplacementService.update(id, emplacementDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/emplacements/{id} : Delete the "id" emplacement.
     *
     * @param id the id of the emplacement to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmplacement(@PathVariable Integer id) {
        emplacementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}