package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateZoneDistributionRequestDto;
import com.mera.shine.dto.response.ZoneDistributionDto;
import com.mera.shine.service.ZoneDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing ZoneDistribution entities.
 */
@RestController
@RequestMapping("/api/zone-distributions")
public class ZoneDistributionController {

    private final ZoneDistributionService zoneDistributionService;

    @Autowired
    public ZoneDistributionController(ZoneDistributionService zoneDistributionService) {
        this.zoneDistributionService = zoneDistributionService;
    }

    /**
     * GET /api/zone-distributions : Get all zone distributions.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of zone distributions in body
     */
    @GetMapping
    public ResponseEntity<List<ZoneDistributionDto>> getAllZoneDistributions() {
        List<ZoneDistributionDto> zoneDistributions = zoneDistributionService.findAll();
        return ResponseEntity.ok(zoneDistributions);
    }

    /**
     * GET /api/zone-distributions/{id} : Get the "id" zone distribution.
     *
     * @param id the id of the zone distribution to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the zone distribution, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ZoneDistributionDto> getZoneDistribution(@PathVariable Integer id) {
        return zoneDistributionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/zone-distributions/by-site/{siteId} : Get zone distributions by site ID.
     *
     * @param siteId the site ID
     * @return the ResponseEntity with status 200 (OK) and the list of zone distributions in body
     */
    @GetMapping("/by-site/{siteId}")
    public ResponseEntity<List<ZoneDistributionDto>> getZoneDistributionsBySiteId(@PathVariable Integer siteId) {
        List<ZoneDistributionDto> zoneDistributions = zoneDistributionService.findBySiteId(siteId);
        return ResponseEntity.ok(zoneDistributions);
    }

    /**
     * POST /api/zone-distributions : Create a new zone distribution.
     *
     * @param createZoneDistributionDto the zone distribution to create
     * @return the ResponseEntity with status 201 (Created) and with body the new zone distribution
     */
    @PostMapping
    public ResponseEntity<ZoneDistributionDto> createZoneDistribution(@RequestBody CreateZoneDistributionRequestDto createZoneDistributionDto) {
        ZoneDistributionDto result = zoneDistributionService.create(createZoneDistributionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/zone-distributions/{id} : Updates an existing zone distribution.
     *
     * @param id the id of the zone distribution to update
     * @param zoneDistributionDto the zone distribution to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated zone distribution,
     * or with status 404 (Not Found) if the zone distribution is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<ZoneDistributionDto> updateZoneDistribution(
            @PathVariable Integer id,
            @RequestBody ZoneDistributionDto zoneDistributionDto) {
        try {
            ZoneDistributionDto result = zoneDistributionService.update(id, zoneDistributionDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/zone-distributions/{id} : Delete the "id" zone distribution.
     *
     * @param id the id of the zone distribution to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZoneDistribution(@PathVariable Integer id) {
        zoneDistributionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
