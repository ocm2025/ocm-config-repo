package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateTaxeRequestDto;
import com.mera.shine.dto.response.TaxeDto;
import com.mera.shine.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Taxe entities.
 */
@RestController
@RequestMapping("/api/taxes")
public class TaxeController {

    private final TaxeService taxeService;

    @Autowired
    public TaxeController(TaxeService taxeService) {
        this.taxeService = taxeService;
    }

    /**
     * GET /api/taxes : Get all taxes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of taxes in body
     */
    @GetMapping
    public ResponseEntity<List<TaxeDto>> getAllTaxes() {
        List<TaxeDto> taxes = taxeService.findAll();
        return ResponseEntity.ok(taxes);
    }



    /**
     * POST /api/taxes : Create a new tax.
     *
     * @param createTaxeDto the tax to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tax
     */
    @PostMapping
    public ResponseEntity<TaxeDto> createTaxe(@RequestBody CreateTaxeRequestDto createTaxeDto) {
        TaxeDto result = taxeService.create(createTaxeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/taxes/{id} : Updates an existing tax.
     *
     * @param id the id of the tax to update
     * @param taxeDto the tax to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tax,
     * or with status 404 (Not Found) if the tax is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<TaxeDto> updateTaxe(
            @PathVariable Integer id,
            @RequestBody TaxeDto taxeDto) {
        try {
            TaxeDto result = taxeService.update(id, taxeDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/taxes/{id} : Delete the "id" tax.
     *
     * @param id the id of the tax to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaxe(@PathVariable Integer id) {
        taxeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}