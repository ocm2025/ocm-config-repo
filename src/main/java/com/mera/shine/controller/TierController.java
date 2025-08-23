package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateTierRequestDto;
import com.mera.shine.dto.response.TierDto;
import com.mera.shine.service.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Tier entities.
 */
@RestController
@RequestMapping("/api/tiers")
public class TierController {

    private final TierService tierService;

    @Autowired
    public TierController(TierService tierService) {
        this.tierService = tierService;
    }

    /**
     * GET /api/tiers : Get all tiers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tiers in body
     */
    @GetMapping
    public ResponseEntity<List<TierDto>> getAllTiers() {
        List<TierDto> tiers = tierService.findAll();
        return ResponseEntity.ok(tiers);
    }

    /**
     * GET /api/tiers/{id} : Get the "id" tier.
     *
     * @param id the id of the tier to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tier, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TierDto> getTier(@PathVariable Integer id) {
        return tierService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/tiers : Create a new tier.
     *
     * @param createTierDto the tier to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tier
     */
    @PostMapping
    public ResponseEntity<TierDto> createTier(@RequestBody CreateTierRequestDto createTierDto) {
        TierDto result = tierService.create(createTierDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/tiers/{id} : Updates an existing tier.
     *
     * @param id the id of the tier to update
     * @param tierDto the tier to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tier,
     * or with status 404 (Not Found) if the tier is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<TierDto> updateTier(
            @PathVariable Integer id,
            @RequestBody TierDto tierDto) {
        try {
            TierDto result = tierService.update(id, tierDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/tiers/{id} : Delete the "id" tier.
     *
     * @param id the id of the tier to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTier(@PathVariable Integer id) {
        tierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}