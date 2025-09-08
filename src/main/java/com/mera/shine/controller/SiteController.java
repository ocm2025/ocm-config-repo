package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateSiteRequestDto;
import com.mera.shine.dto.response.SiteDto;
import com.mera.shine.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Site entities.
 */
@RestController
@RequestMapping("/api/sites")
public class SiteController {

    private final SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    /**
     * GET /api/sites : Get all sites.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of sites in body
     */
    @GetMapping
    public ResponseEntity<List<SiteDto>> getAllSites() {
        List<SiteDto> sites = siteService.findAll();
        return ResponseEntity.ok(sites);
    }

    @GetMapping("/search-by-societe/{societeId}")
    public ResponseEntity<List<SiteDto>> getAllSitesBySocieteId(@PathVariable Integer societeId) {
        List<SiteDto> sites = siteService.findBySociete(societeId);
        return ResponseEntity.ok(sites);
    }

    /**
     * GET /api/sites/{id} : Get the "id" site.
     *
     * @param id the id of the site to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the site, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<SiteDto> getSite(@PathVariable Integer id) {
        return siteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/sites : Create a new site.
     *
     * @param createSiteDto the site to create
     * @return the ResponseEntity with status 201 (Created) and with body the new site
     */
    @PostMapping
    public ResponseEntity<SiteDto> createSite(@RequestBody CreateSiteRequestDto createSiteDto) {
        SiteDto result = siteService.create(createSiteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/sites/{id} : Updates an existing site.
     *
     * @param id the id of the site to update
     * @param siteDto the site to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated site,
     * or with status 404 (Not Found) if the site is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<SiteDto> updateSite(
            @PathVariable Integer id,
            @RequestBody SiteDto siteDto) {
        try {
            SiteDto result = siteService.update(id, siteDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/sites/{id} : Delete the "id" site.
     *
     * @param id the id of the site to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable Integer id) {
        siteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}