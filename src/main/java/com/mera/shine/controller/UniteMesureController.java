package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateUniteMesureRequestDto;
import com.mera.shine.dto.response.UniteMesureDto;
import com.mera.shine.service.UniteMesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing UniteMesure entities.
 */
@RestController
@RequestMapping("/api/unites-mesure")
public class UniteMesureController {

    private final UniteMesureService uniteMesureService;

    @Autowired
    public UniteMesureController(UniteMesureService uniteMesureService) {
        this.uniteMesureService = uniteMesureService;
    }

    /**
     * GET /api/unites-mesure : Get all unites mesure.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of unites mesure in body
     */
    @GetMapping
    public ResponseEntity<List<UniteMesureDto>> getAllUnitesMesure() {
        List<UniteMesureDto> unitesMesure = uniteMesureService.findAll();
        return ResponseEntity.ok(unitesMesure);
    }

    /**
     * GET /api/unites-mesure/{id} : Get the "id" unite mesure.
     *
     * @param id the id of the unite mesure to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the unite mesure, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<UniteMesureDto> getUniteMesure(@PathVariable Integer id) {
        return uniteMesureService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/unites-mesure : Create a new unite mesure.
     *
     * @param createUniteMesureDto the unite mesure to create
     * @return the ResponseEntity with status 201 (Created) and with body the new unite mesure
     */
    @PostMapping
    public ResponseEntity<UniteMesureDto> createUniteMesure(@RequestBody CreateUniteMesureRequestDto createUniteMesureDto) {
        UniteMesureDto result = uniteMesureService.create(createUniteMesureDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/unites-mesure/{id} : Updates an existing unite mesure.
     *
     * @param id the id of the unite mesure to update
     * @param uniteMesureDto the unite mesure to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated unite mesure,
     * or with status 404 (Not Found) if the unite mesure is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<UniteMesureDto> updateUniteMesure(
            @PathVariable Integer id,
            @RequestBody UniteMesureDto uniteMesureDto) {
        try {
            UniteMesureDto result = uniteMesureService.update(id, uniteMesureDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/unites-mesure/{id} : Delete the "id" unite mesure.
     *
     * @param id the id of the unite mesure to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniteMesure(@PathVariable Integer id) {
        uniteMesureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}