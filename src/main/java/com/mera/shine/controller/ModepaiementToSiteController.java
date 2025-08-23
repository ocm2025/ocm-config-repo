package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateModepaiementToSiteRequestDto;
import com.mera.shine.dto.response.ModepaiementToSiteDto;
import com.mera.shine.service.ModepaiementToSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing ModepaiementToSite entities.
 */
@RestController
@RequestMapping("/api/modepaiement-to-sites")
public class ModepaiementToSiteController {

    private final ModepaiementToSiteService modepaiementToSiteService;

    @Autowired
    public ModepaiementToSiteController(ModepaiementToSiteService modepaiementToSiteService) {
        this.modepaiementToSiteService = modepaiementToSiteService;
    }

    /**
     * GET /api/modepaiement-to-sites : Get all payment method to site mappings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of payment method to site mappings in body
     */
    @GetMapping
    public ResponseEntity<List<ModepaiementToSiteDto>> getAllModepaiementToSites() {
        List<ModepaiementToSiteDto> modepaiementToSites = modepaiementToSiteService.findAll();
        return ResponseEntity.ok(modepaiementToSites);
    }

    /**
     * GET /api/modepaiement-to-sites/{id} : Get the "id" payment method to site mapping.
     *
     * @param id the id of the payment method to site mapping to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the payment method to site mapping, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ModepaiementToSiteDto> getModepaiementToSite(@PathVariable Integer id) {
        return modepaiementToSiteService.findById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/modepaiement-to-sites : Create a new payment method to site mapping.
     *
     * @param createModepaiementToSiteDto the payment method to site mapping to create
     * @return the ResponseEntity with status 201 (Created) and with body the new payment method to site mapping
     */
    @PostMapping
    public ResponseEntity<ModepaiementToSiteDto> createModepaiementToSite(@RequestBody CreateModepaiementToSiteRequestDto createModepaiementToSiteDto) {
        ModepaiementToSiteDto result = modepaiementToSiteService.create(createModepaiementToSiteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/modepaiement-to-sites/{id} : Updates an existing payment method to site mapping.
     *
     * @param id the id of the payment method to site mapping to update
     * @param modepaiementToSiteDto the payment method to site mapping to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated payment method to site mapping,
     * or with status 404 (Not Found) if the payment method to site mapping is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<ModepaiementToSiteDto> updateModepaiementToSite(
            @PathVariable Integer id,
            @RequestBody ModepaiementToSiteDto modepaiementToSiteDto) {
        try {
            ModepaiementToSiteDto result = modepaiementToSiteService.update(id, modepaiementToSiteDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/modepaiement-to-sites/{id} : Delete the "id" payment method to site mapping.
     *
     * @param id the id of the payment method to site mapping to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModepaiementToSite(@PathVariable Integer id) {
        modepaiementToSiteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
