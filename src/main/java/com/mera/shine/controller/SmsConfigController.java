package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateSmsConfigRequestDto;
import com.mera.shine.dto.response.SmsConfigDto;
import com.mera.shine.service.SmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing SmsConfig entities.
 */
@RestController
@RequestMapping("/api/sms-configs")
public class SmsConfigController {

    private final SmsConfigService smsConfigService;

    @Autowired
    public SmsConfigController(SmsConfigService smsConfigService) {
        this.smsConfigService = smsConfigService;
    }

    /**
     * GET /api/sms-configs : Get all SMS configurations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of SMS configurations in body
     */
    @GetMapping
    public ResponseEntity<List<SmsConfigDto>> getAllSmsConfigs() {
        List<SmsConfigDto> smsConfigs = smsConfigService.findAll();
        return ResponseEntity.ok(smsConfigs);
    }

    /**
     * GET /api/sms-configs/{id} : Get the "id" SMS configuration.
     *
     * @param id the id of the SMS configuration to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the SMS configuration, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<SmsConfigDto> getSmsConfig(@PathVariable Integer id) {
        return smsConfigService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/sms-configs : Create a new SMS configuration.
     *
     * @param createSmsConfigDto the SMS configuration to create
     * @return the ResponseEntity with status 201 (Created) and with body the new SMS configuration
     */
    @PostMapping
    public ResponseEntity<SmsConfigDto> createSmsConfig(@RequestBody CreateSmsConfigRequestDto createSmsConfigDto) {
        SmsConfigDto result = smsConfigService.create(createSmsConfigDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/sms-configs/{id} : Updates an existing SMS configuration.
     *
     * @param id the id of the SMS configuration to update
     * @param smsConfigDto the SMS configuration to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated SMS configuration,
     * or with status 404 (Not Found) if the SMS configuration is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<SmsConfigDto> updateSmsConfig(
            @PathVariable Integer id,
            @RequestBody SmsConfigDto smsConfigDto) {
        try {
            SmsConfigDto result = smsConfigService.update(id, smsConfigDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/sms-configs/{id} : Delete the "id" SMS configuration.
     *
     * @param id the id of the SMS configuration to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSmsConfig(@PathVariable Integer id) {
        smsConfigService.delete(id);
        return ResponseEntity.noContent().build();
    }
}