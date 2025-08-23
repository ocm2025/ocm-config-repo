package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.SocieteDto;
import com.mera.shine.service.SocieteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Societe entities.
 */
@RestController
@RequestMapping("/api/societes")
@Tag(name = "Societe", description = "The Societe API")
public class SocieteController {

    private final SocieteService societeService;

    @Autowired
    public SocieteController(SocieteService societeService) {
        this.societeService = societeService;
    }

    /**
     * GET /api/societes : Get all societes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of societes in body
     */
    @Operation(summary = "Get all societes", description = "Returns a list of all societes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of societes",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = SocieteDto.class)))
    })
    @GetMapping
    public ResponseEntity<List<SocieteDto>> getAllSocietes() {
        List<SocieteDto> societes = societeService.findAll();
        return ResponseEntity.ok(societes);
    }

    /**
     * GET /api/societes/{id} : Get the "id" societe.
     *
     * @param id the id of the societe to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the societe, or with status 404 (Not Found)
     */
    @Operation(summary = "Get a societe by id", description = "Returns a societe as per the id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the societe",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = SocieteDto.class))),
        @ApiResponse(responseCode = "404", description = "Societe not found",
                content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<SocieteDto> getSociete(
            @Parameter(description = "ID of the societe to be obtained", required = true)
            @PathVariable Integer id) {
        return societeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/societes : Create a new societe.
     *
     * @param createSocieteDto the societe to create
     * @return the ResponseEntity with status 201 (Created) and with body the new societe
     */
    @Operation(summary = "Create a new societe", description = "Creates a new societe and returns the created entity")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Societe created successfully",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = SocieteDto.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input",
                content = @Content)
    })
    @PostMapping
    public ResponseEntity<SocieteDto> createSociete(
            @Parameter(description = "Societe to create", required = true, 
                    schema = @Schema(implementation = CreateSocieteRequestDto.class))
            @RequestBody CreateSocieteRequestDto createSocieteDto) {
        SocieteDto result = societeService.create(createSocieteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/societes/{id} : Updates an existing societe.
     *
     * @param id the id of the societe to update
     * @param societeDto the societe to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated societe,
     * or with status 404 (Not Found) if the societe is not found
     */
    @Operation(summary = "Update an existing societe", description = "Updates a societe and returns the updated entity")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Societe updated successfully",
                content = @Content(mediaType = "application/json", 
                schema = @Schema(implementation = SocieteDto.class))),
        @ApiResponse(responseCode = "404", description = "Societe not found",
                content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input",
                content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<SocieteDto> updateSociete(
            @Parameter(description = "ID of the societe to be updated", required = true)
            @PathVariable Integer id,
            @Parameter(description = "Updated societe information", required = true, 
                    schema = @Schema(implementation = SocieteDto.class))
            @RequestBody SocieteDto societeDto) {
        try {
            SocieteDto result = societeService.update(id, societeDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/societes/{id} : Delete the "id" societe.
     *
     * @param id the id of the societe to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @Operation(summary = "Delete a societe", description = "Deletes a societe by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Societe deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Societe not found",
                content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSociete(
            @Parameter(description = "ID of the societe to be deleted", required = true)
            @PathVariable Integer id) {
        societeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
