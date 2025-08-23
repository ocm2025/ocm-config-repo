package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateCurrencyToSiteRequestDto;
import com.mera.shine.dto.response.CurrencyToSiteDto;
import com.mera.shine.service.CurrencyToSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing CurrencyToSite entities.
 */
@RestController
@RequestMapping("/api/currency-to-sites")
public class CurrencyToSiteController {

    private final CurrencyToSiteService currencyToSiteService;

    @Autowired
    public CurrencyToSiteController(CurrencyToSiteService currencyToSiteService) {
        this.currencyToSiteService = currencyToSiteService;
    }

    /**
     * GET /api/currency-to-sites : Get all currency to site mappings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of currency to site mappings in body
     */
    @GetMapping
    public ResponseEntity<List<CurrencyToSiteDto>> getAllCurrencyToSites() {
        List<CurrencyToSiteDto> currencyToSites = currencyToSiteService.findAll();
        return ResponseEntity.ok(currencyToSites);
    }



    /**
     * POST /api/currency-to-sites : Create a new currency to site mapping.
     *
     * @param createCurrencyToSiteDto the currency to site mapping to create
     * @return the ResponseEntity with status 201 (Created) and with body the new currency to site mapping
     */
    @PostMapping
    public ResponseEntity<CurrencyToSiteDto> createCurrencyToSite(@RequestBody CreateCurrencyToSiteRequestDto createCurrencyToSiteDto) {
        CurrencyToSiteDto result = currencyToSiteService.create(createCurrencyToSiteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/currency-to-sites/{id} : Updates an existing currency to site mapping.
     *
     * @param id the id of the currency to site mapping to update
     * @param currencyToSiteDto the currency to site mapping to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated currency to site mapping,
     * or with status 404 (Not Found) if the currency to site mapping is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<CurrencyToSiteDto> updateCurrencyToSite(
            @PathVariable Integer id,
            @RequestBody CurrencyToSiteDto currencyToSiteDto) {
        try {
            CurrencyToSiteDto result = currencyToSiteService.update(id, currencyToSiteDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/currency-to-sites/{id} : Delete the "id" currency to site mapping.
     *
     * @param id the id of the currency to site mapping to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrencyToSite(@PathVariable Integer id) {
        currencyToSiteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}