package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateModePaiementRequestDto;
import com.mera.shine.dto.response.ModePaiementDto;
import com.mera.shine.service.ModePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing ModePaiement entities.
 */
@RestController
@RequestMapping("/api/mode-paiements")
public class ModePaiementController {

    private final ModePaiementService modePaiementService;

    @Autowired
    public ModePaiementController(ModePaiementService modePaiementService) {
        this.modePaiementService = modePaiementService;
    }

    /**
     * GET /api/mode-paiements : Get all payment methods.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of payment methods in body
     */
    @GetMapping
    public ResponseEntity<List<ModePaiementDto>> getAllModePaiements() {
        List<ModePaiementDto> modePaiements = modePaiementService.findAll();
        return ResponseEntity.ok(modePaiements);
    }

    /**
     * GET /api/mode-paiements/{id} : Get the "id" payment method.
     *
     * @param id the id of the payment method to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the payment method, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ModePaiementDto> getModePaiement(@PathVariable Integer id) {
        return modePaiementService.findById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/mode-paiements/by-societe/{societeId} : Get payment methods by société ID.
     *
     * @param societeId the société ID
     * @return the ResponseEntity with status 200 (OK) and the list of payment methods in body
     */
    @GetMapping("/by-societe/{societeId}")
    public ResponseEntity<List<ModePaiementDto>> getModePaiementsBySocieteId(@PathVariable Integer societeId) {
        List<ModePaiementDto> modePaiements = modePaiementService.findBySocieteId(societeId);
        return ResponseEntity.ok(modePaiements);
    }

    /**
     * POST /api/mode-paiements : Create a new payment method.
     *
     * @param createModePaiementDto the payment method to create
     * @return the ResponseEntity with status 201 (Created) and with body the new payment method
     */
    @PostMapping
    public ResponseEntity<ModePaiementDto> createModePaiement(@RequestBody CreateModePaiementRequestDto createModePaiementDto) {
        ModePaiementDto result = modePaiementService.create(createModePaiementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/mode-paiements/{id} : Updates an existing payment method.
     *
     * @param id the id of the payment method to update
     * @param modePaiementDto the payment method to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated payment method,
     * or with status 404 (Not Found) if the payment method is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<ModePaiementDto> updateModePaiement(
            @PathVariable Integer id,
            @RequestBody ModePaiementDto modePaiementDto) {
        try {
            ModePaiementDto result = modePaiementService.update(id, modePaiementDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/mode-paiements/{id} : Delete the "id" payment method.
     *
     * @param id the id of the payment method to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModePaiement(@PathVariable Integer id) {
        modePaiementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
