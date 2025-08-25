package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.service.SuperAdminService;
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

import jakarta.validation.Valid;

/**
 * REST controller for Super Admin operations.
 */
@RestController
@RequestMapping("/api/super-admin")
@Tag(name = "Super Admin", description = "The Super Admin API for system initialization")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @Autowired
    public SuperAdminController(SuperAdminService superAdminService) {
        this.superAdminService = superAdminService;
    }

    /**
     * POST /api/super-admin/create-society-and-init : Create a new society and initialize all default entities.
     *
     * @param createSocieteDto the society to create
     * @return the ResponseEntity with status 201 (Created) if successful, or 500 (Internal Server Error) if failed
     */
    @Operation(summary = "Create society and initialize default entities", 
               description = "Creates a new society and initializes all default entities (payment methods, units of measure, taxes, site, tiers, users, groups, etc.)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Society created and initialized successfully",
                content = @Content(mediaType = "application/json")),
        @ApiResponse(responseCode = "400", description = "Invalid input data",
                content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error during creation or initialization",
                content = @Content)
    })
    @PostMapping("/create-society-and-init")
    public ResponseEntity<String> createSocietyAndInitEntity(
            @Parameter(description = "Society data to create", required = true, 
                    schema = @Schema(implementation = CreateSocieteRequestDto.class))
            @Valid @RequestBody CreateSocieteRequestDto createSocieteDto) {
        
        try {
            boolean success = superAdminService.createSocietyAndInitEntity(createSocieteDto);
            
            if (success) {
                return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Society created and all default entities initialized successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create society and initialize default entities");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error occurred while creating society: " + e.getMessage());
        }
    }
}