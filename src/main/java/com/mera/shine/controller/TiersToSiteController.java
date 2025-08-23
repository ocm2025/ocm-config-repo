package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateTiersToSiteRequestDto;
import com.mera.shine.dto.response.TiersToSiteDto;
import com.mera.shine.service.TiersToSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing TiersToSite entities.
 */
@RestController
@RequestMapping("/api/tiers-to-sites")
public class TiersToSiteController {

    private final TiersToSiteService tiersToSiteService;

    @Autowired
    public TiersToSiteController(TiersToSiteService tiersToSiteService) {
        this.tiersToSiteService = tiersToSiteService;
    }

    /**
     * GET /api/tiers-to-sites : Get all tier to site mappings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tier to site mappings in body
     */
    @GetMapping
    public ResponseEntity<List<TiersToSiteDto>> getAllTiersToSites() {
        List<TiersToSiteDto> tiersToSites = tiersToSiteService.findAll();
        return ResponseEntity.ok(tiersToSites);
    }

    /**
     * GET /api/tiers-to-sites/{id} : Get the "id" tier to site mapping.
     *
     * @param id the id of the tier to site mapping to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tier to site mapping, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TiersToSiteDto> getTiersToSite(@PathVariable Integer id) {
        return tiersToSiteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    /**
     * POST /api/tiers-to-sites : Create a new tier to site mapping.
     *
     * @param createTiersToSiteDto the tier to site mapping to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tier to site mapping
     */
    @PostMapping
    public ResponseEntity<TiersToSiteDto> createTiersToSite(@RequestBody CreateTiersToSiteRequestDto createTiersToSiteDto) {
        TiersToSiteDto result = tiersToSiteService.create(createTiersToSiteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/tiers-to-sites/{id} : Updates an existing tier to site mapping.
     *
     * @param id the id of the tier to site mapping to update
     * @param tiersToSiteDto the tier to site mapping to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tier to site mapping,
     * or with status 404 (Not Found) if the tier to site mapping is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<TiersToSiteDto> updateTiersToSite(
            @PathVariable Integer id,
            @RequestBody TiersToSiteDto tiersToSiteDto) {
        try {
            TiersToSiteDto result = tiersToSiteService.update(id, tiersToSiteDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/tiers-to-sites/{id} : Delete the "id" tier to site mapping.
     *
     * @param id the id of the tier to site mapping to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTiersToSite(@PathVariable Integer id) {
        tiersToSiteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}