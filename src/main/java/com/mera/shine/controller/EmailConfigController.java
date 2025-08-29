package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateEmailConfigRequestDto;
import com.mera.shine.dto.response.EmailConfigDto;
import com.mera.shine.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing EmailConfig entities.
 */
@RestController
@RequestMapping("/api/email-configs")
public class EmailConfigController {

    private final EmailConfigService emailConfigService;

    @Autowired
    public EmailConfigController(EmailConfigService emailConfigService) {
        this.emailConfigService = emailConfigService;
    }

    /**
     * GET /api/email-configs : Get all email configurations.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of email configurations in body
     */
    @GetMapping
    public ResponseEntity<List<EmailConfigDto>> getAllEmailConfigs() {
        List<EmailConfigDto> emailConfigs = emailConfigService.findAll();
        return ResponseEntity.ok(emailConfigs);
    }

    /**
     * GET /api/email-configs/{id} : Get the "id" email configuration.
     *
     * @param id the id of the email configuration to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the email configuration, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmailConfigDto> getEmailConfig(@PathVariable Integer id) {
        return emailConfigService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/email-configs : Create a new email configuration.
     *
     * @param createEmailConfigDto the email configuration to create
     * @return the ResponseEntity with status 201 (Created) and with body the new email configuration
     */
    @PostMapping
    public ResponseEntity<EmailConfigDto> createEmailConfig(@RequestBody CreateEmailConfigRequestDto createEmailConfigDto) {
        EmailConfigDto result = emailConfigService.create(createEmailConfigDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/email-configs/{id} : Updates an existing email configuration.
     *
     * @param id the id of the email configuration to update
     * @param emailConfigDto the email configuration to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated email configuration,
     * or with status 404 (Not Found) if the email configuration is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmailConfigDto> updateEmailConfig(
            @PathVariable Integer id,
            @RequestBody EmailConfigDto emailConfigDto) {
        try {
            EmailConfigDto result = emailConfigService.update(id, emailConfigDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/email-configs/{id} : Delete the "id" email configuration.
     *
     * @param id the id of the email configuration to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmailConfig(@PathVariable Integer id) {
        emailConfigService.delete(id);
        return ResponseEntity.noContent().build();
    }
}