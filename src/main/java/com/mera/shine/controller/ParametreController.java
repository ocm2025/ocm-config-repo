package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateParametreRequestDto;
import com.mera.shine.dto.response.ParametreDto;
import com.mera.shine.service.ParametreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Parametre entities.
 */
@RestController
@RequestMapping("/api/parametres")
public class ParametreController {

    private final ParametreService parametreService;

    @Autowired
    public ParametreController(ParametreService parametreService) {
        this.parametreService = parametreService;
    }

    /**
     * GET /api/parametres : Get all parameters.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of parameters in body
     */
    @GetMapping
    public ResponseEntity<List<ParametreDto>> getAllParametres() {
        List<ParametreDto> parametres = parametreService.findAll();
        return ResponseEntity.ok(parametres);
    }

    /**
     * GET /api/parametres/{id} : Get the "id" parameter.
     *
     * @param id the id of the parameter to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the parameter, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ParametreDto> getParametre(@PathVariable Integer id) {
        return parametreService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    /**
     * POST /api/parametres : Create a new parameter.
     *
     * @param createParametreDto the parameter to create
     * @return the ResponseEntity with status 201 (Created) and with body the new parameter
     */
    @PostMapping
    public ResponseEntity<ParametreDto> createParametre(@RequestBody CreateParametreRequestDto createParametreDto) {
        ParametreDto result = parametreService.create(createParametreDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/parametres/{id} : Updates an existing parameter.
     *
     * @param id the id of the parameter to update
     * @param parametreDto the parameter to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated parameter,
     * or with status 404 (Not Found) if the parameter is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<ParametreDto> updateParametre(
            @PathVariable Integer id,
            @RequestBody ParametreDto parametreDto) {
        try {
            ParametreDto result = parametreService.update(id, parametreDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/parametres/{id} : Delete the "id" parameter.
     *
     * @param id the id of the parameter to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParametre(@PathVariable Integer id) {
        parametreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}