package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateLoginLogRequestDto;
import com.mera.shine.dto.response.LoginLogDto;
import com.mera.shine.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing LoginLog entities.
 */
@RestController
@RequestMapping("/api/login-logs")
public class LoginLogController {

    private final LoginLogService loginLogService;

    @Autowired
    public LoginLogController(LoginLogService loginLogService) {

        this.loginLogService = loginLogService;
    }

    /**
     * GET /api/login-logs : Get all login logs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of login logs in body
     */
    @GetMapping
    public ResponseEntity<List<LoginLogDto>> getAllLoginLogs() {
        List<LoginLogDto> loginLogs = loginLogService.findAll();
        return ResponseEntity.ok(loginLogs);
    }

    /**
     * GET /api/login-logs/{id} : Get the "id" login log.
     *
     * @param id the id of the login log to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the login log, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LoginLogDto> getLoginLog(@PathVariable Integer id) {
        return loginLogService.findById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }


    /**
     * POST /api/login-logs : Create a new login log.
     *
     * @param createLoginLogDto the login log to create
     * @return the ResponseEntity with status 201 (Created) and with body the new login log
     */
    @PostMapping
    public ResponseEntity<LoginLogDto> createLoginLog(@RequestBody CreateLoginLogRequestDto createLoginLogDto) {
        LoginLogDto result = loginLogService.create(createLoginLogDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * PUT /api/login-logs/{id} : Updates an existing login log.
     *
     * @param id the id of the login log to update
     * @param loginLogDto the login log to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated login log,
     * or with status 404 (Not Found) if the login log is not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<LoginLogDto> updateLoginLog(
            @PathVariable Integer id,
            @RequestBody LoginLogDto loginLogDto) {
        try {
            LoginLogDto result = loginLogService.update(id, loginLogDto);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/login-logs/{id} : Delete the "id" login log.
     *
     * @param id the id of the login log to delete
     * @return the ResponseEntity with status 204 (NO_CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoginLog(@PathVariable Integer id) {
        loginLogService.delete(id);
        return ResponseEntity.noContent().build();
    }
}