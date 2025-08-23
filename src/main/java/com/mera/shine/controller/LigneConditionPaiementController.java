package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateLigneConditionPaiementRequestDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;
import com.mera.shine.service.LigneConditionPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing LigneConditionPaiement entities.
 */
@RestController
@RequestMapping("/api/ligne-condition-paiements")
public class LigneConditionPaiementController {

    private final LigneConditionPaiementService ligneConditionPaiementService;

    @Autowired
    public LigneConditionPaiementController(LigneConditionPaiementService ligneConditionPaiementService) {
        this.ligneConditionPaiementService = ligneConditionPaiementService;
    }

    /**
     * GET /api/ligne-condition-paiements : Get all ligne condition paiements.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of ligne condition paiements in body
     */
    @GetMapping
    public ResponseEntity<List<LigneConditionPaiementDto>> getAllLigneConditionPaiements() {
        List<LigneConditionPaiementDto> ligneConditionPaiements = ligneConditionPaiementService.findAll();
        return ResponseEntity.ok(ligneConditionPaiements);
    }


    /**
     * GET /api/ligne-condition-paiements/{id} : Get the "id" ligne condition paiement.
     *
     * @param id the id of the ligne condition paiement to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ligne condition paiement, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LigneConditionPaiementDto> getLigneConditionPaiement(@PathVariable Integer id) {
        return ligneConditionPaiementService.findById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/ligne-condition-paiements : Create a new ligne condition paiement.
     *
     * @param createLigneConditionPaiementDto the ligne condition paiement to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ligne condition paiement
     */
    @PostMapping
    public ResponseEntity<LigneConditionPaiementDto> createLigneConditionPaiement(@RequestBody CreateLigneConditionPaiementRequestDto createLigneConditionPaiementDto) {
        LigneConditionPaiementDto result = ligneConditionPaiementService.create(createLigneConditionPaiementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/ligne-condition-paiements/{id} : Updates an existing ligne condition paiement.
     *
     * @param id the id of the ligne condition paiement to update
     * @param ligneConditionPaiementDto the ligne condition paiement to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ligne condition paiement,
     * or with status 404 (Not Found) if the ligne condition paiement is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<LigneConditionPaiementDto> updateLigneConditionPaiement(
            @PathVariable Integer id,
            @RequestBody LigneConditionPaiementDto ligneConditionPaiementDto) {
        try {
            LigneConditionPaiementDto result = ligneConditionPaiementService.update(id, ligneConditionPaiementDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/ligne-condition-paiements/{id} : Delete the "id" ligne condition paiement.
     *
     * @param id the id of the ligne condition paiement to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigneConditionPaiement(@PathVariable Integer id) {
        ligneConditionPaiementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}