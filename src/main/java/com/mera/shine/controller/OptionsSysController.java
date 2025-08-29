package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateOptionsSysRequestDto;
import com.mera.shine.dto.response.OptionsSysDto;
import com.mera.shine.service.OptionsSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing OptionsSys entities.
 */
@RestController
@RequestMapping("/api/options-sys")
public class OptionsSysController {

    private final OptionsSysService optionsSysService;

    @Autowired
    public OptionsSysController(OptionsSysService optionsSysService) {
        this.optionsSysService = optionsSysService;
    }

    /**
     * GET /api/options-sys : Get all system options.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of system options in body
     */
    @GetMapping
    public ResponseEntity<List<OptionsSysDto>> getAllOptionsSys() {
        List<OptionsSysDto> optionsSys = optionsSysService.findAll();
        return ResponseEntity.ok(optionsSys);
    }

    /**
     * GET /api/options-sys/{id} : Get the "id" system option.
     *
     * @param id the id of the system option to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the system option, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<OptionsSysDto> getOptionsSys(@PathVariable Integer id) {
        return optionsSysService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/options-sys : Create a new system option.
     *
     * @param createOptionsSysDto the system option to create
     * @return the ResponseEntity with status 201 (Created) and with body the new system option
     */
    @PostMapping
    public ResponseEntity<OptionsSysDto> createOptionsSys(@RequestBody CreateOptionsSysRequestDto createOptionsSysDto) {
        OptionsSysDto result = optionsSysService.create(createOptionsSysDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/options-sys/{id} : Updates an existing system option.
     *
     * @param id the id of the system option to update
     * @param optionsSysDto the system option to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated system option,
     * or with status 404 (Not Found) if the system option is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<OptionsSysDto> updateOptionsSys(
            @PathVariable Integer id,
            @RequestBody OptionsSysDto optionsSysDto) {
        try {
            OptionsSysDto result = optionsSysService.update(id, optionsSysDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/options-sys/{id} : Delete the "id" system option.
     *
     * @param id the id of the system option to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptionsSys(@PathVariable Integer id) {
        optionsSysService.delete(id);
        return ResponseEntity.noContent().build();
    }
}