package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateCurrencyRequestDto;
import com.mera.shine.dto.response.CurrencyDto;
import com.mera.shine.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Currency entities.
 */
@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    /**
     * GET /api/currencies : Get all currencies.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of currencies in body
     */
    @GetMapping
    public ResponseEntity<List<CurrencyDto>> getAllCurrencies() {
        List<CurrencyDto> currencies = currencyService.findAll();
        return ResponseEntity.ok(currencies);
    }

    /**
     * GET /api/currencies/{id} : Get the "id" currency.
     *
     * @param id the id of the currency to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the currency, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<CurrencyDto> getCurrency(@PathVariable Integer id) {
        return currencyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/currencies : Create a new currency.
     *
     * @param createCurrencyDto the currency to create
     * @return the ResponseEntity with status 201 (Created) and with body the new currency
     */
    @PostMapping
    public ResponseEntity<CurrencyDto> createCurrency(@RequestBody CreateCurrencyRequestDto createCurrencyDto) {
        CurrencyDto result = currencyService.create(createCurrencyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/currencies/{id} : Updates an existing currency.
     *
     * @param id the id of the currency to update
     * @param currencyDto the currency to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated currency,
     * or with status 404 (Not Found) if the currency is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<CurrencyDto> updateCurrency(
            @PathVariable Integer id,
            @RequestBody CurrencyDto currencyDto) {
        try {
            CurrencyDto result = currencyService.update(id, currencyDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/currencies/{id} : Delete the "id" currency.
     *
     * @param id the id of the currency to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Integer id) {
        currencyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}