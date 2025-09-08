package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateUtilisateurRequestDto;
import com.mera.shine.dto.response.UtilisateurDto;
import com.mera.shine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for managing Utilisateur entities.
 */
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    /**
     * GET /api/utilisateurs : Get all utilisateurs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of utilisateurs in body
     */
    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurs = utilisateurService.findAll();
        return ResponseEntity.ok(utilisateurs);
    }

    /**
     * GET /api/utilisateurs/{id} : Get the "id" utilisateur.
     *
     * @param id the id of the utilisateur to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the utilisateur, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateur(@PathVariable Integer id) {
        return utilisateurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/utilisateurs/by-societe : Get utilisateurs by société ID.
     *
     * @param societeId the société ID
     * @return the ResponseEntity with status 200 (OK) and the list of utilisateurs in body
     */
    @GetMapping("/by-societe/{societeId}")
    public ResponseEntity<List<UtilisateurDto>> getUtilisateursBySocieteId(@PathVariable Integer societeId) {
        List<UtilisateurDto> utilisateurs = utilisateurService.findBySocieteId(societeId);
        return ResponseEntity.ok(utilisateurs);
    }

    /**
     * GET /api/utilisateurs/by-site : Get utilisateurs by site ID.
     *
     * @param siteId the site ID
     * @return the ResponseEntity with status 200 (OK) and the list of utilisateurs in body
     */
    @GetMapping("/by-site/{siteId}")
    public ResponseEntity<List<UtilisateurDto>> getUtilisateursBySiteId(@PathVariable Integer siteId) {
        List<UtilisateurDto> utilisateurs = utilisateurService.findBySiteId(siteId);
        return ResponseEntity.ok(utilisateurs);
    }

    /**
     * POST /api/utilisateurs : Create a new utilisateur.
     *
     * @param createUtilisateurDto the utilisateur to create
     * @return the ResponseEntity with status 201 (Created) and with body the new utilisateur
     */
    @PostMapping
    public ResponseEntity<UtilisateurDto> createUtilisateur(@RequestBody CreateUtilisateurRequestDto createUtilisateurDto) {
        UtilisateurDto result = utilisateurService.create(createUtilisateurDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/utilisateurs/{id} : Updates an existing utilisateur.
     *
     * @param id the id of the utilisateur to update
     * @param utilisateurDto the utilisateur to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated utilisateur,
     * or with status 404 (Not Found) if the utilisateur is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> updateUtilisateur(
            @PathVariable Integer id,
            @RequestBody UtilisateurDto utilisateurDto) {
        try {
            UtilisateurDto result = utilisateurService.update(id, utilisateurDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/utilisateurs/{id} : Delete the "id" utilisateur.
     *
     * @param id the id of the utilisateur to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
