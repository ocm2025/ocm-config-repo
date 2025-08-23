package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.response.AdresseDto;
import com.mera.shine.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Adresse entities.
 */
@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    private final AdresseService adresseService;

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    /**
     * GET /api/adresses : Get all addresses.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of addresses in body
     */
    @GetMapping
    public ResponseEntity<List<AdresseDto>> getAllAdresses() {
        List<AdresseDto> adresses = adresseService.findAll();
        return ResponseEntity.ok(adresses);
    }


    /**
     * GET /api/adresses/{id} : Get the "id" address.
     *
     * @param id the id of the address to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the address, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<AdresseDto> getAdresse(@PathVariable Integer id) {
        return adresseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/adresses : Create a new address.
     *
     * @param createAdresseDto the address to create
     * @return the ResponseEntity with status 201 (Created) and with body the new address
     */
    @PostMapping
    public ResponseEntity<AdresseDto> createAdresse(@RequestBody CreateAdresseRequestDto createAdresseDto) {
        AdresseDto result = adresseService.create(createAdresseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/adresses/{id} : Updates an existing address.
     *
     * @param id the id of the address to update
     * @param adresseDto the address to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated address,
     * or with status 404 (Not Found) if the address is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<AdresseDto> updateAdresse(
            @PathVariable Integer id,
            @RequestBody AdresseDto adresseDto) {
        try {
            AdresseDto result = adresseService.update(id, adresseDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/adresses/{id} : Delete the "id" address.
     *
     * @param id the id of the address to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdresse(@PathVariable Integer id) {
        adresseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}