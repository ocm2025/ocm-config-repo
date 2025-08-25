package com.mera.shine.controller;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.service.SuperAdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SuperAdminControllerTest {

    @Mock
    private SuperAdminService superAdminService;

    private SuperAdminController superAdminController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        superAdminController = new SuperAdminController(superAdminService);
        mockMvc = MockMvcBuilders.standaloneSetup(superAdminController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testCreateSocietyAndInitEntity_Success() throws Exception {
        // Given
        CreateSocieteRequestDto requestDto = new CreateSocieteRequestDto(
            "Test Company",
            "Test Activity",
            "Test Address",
            "BP 123",
            "Cameroon",
            "Centre",
            "123456789",
            "NC123",
            "RCCM123",
            "Normal",
            "XAF",
            "logo.png",
            "favicon.ico"
        );

        when(superAdminService.createSocietyAndInitEntity(any(CreateSocieteRequestDto.class)))
            .thenReturn(true);

        // When & Then
        mockMvc.perform(post("/api/super-admin/create-society-and-init")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Society created and all default entities initialized successfully"));

        verify(superAdminService, times(1)).createSocietyAndInitEntity(any(CreateSocieteRequestDto.class));
    }

    @Test
    void testCreateSocietyAndInitEntity_Failure() throws Exception {
        // Given
        CreateSocieteRequestDto requestDto = new CreateSocieteRequestDto(
            "Test Company",
            "Test Activity",
            "Test Address",
            "BP 123",
            "Cameroon",
            "Centre",
            "123456789",
            "NC123",
            "RCCM123",
            "Normal",
            "XAF",
            "logo.png",
            "favicon.ico"
        );

        when(superAdminService.createSocietyAndInitEntity(any(CreateSocieteRequestDto.class)))
            .thenReturn(false);

        // When & Then
        mockMvc.perform(post("/api/super-admin/create-society-and-init")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Failed to create society and initialize default entities"));

        verify(superAdminService, times(1)).createSocietyAndInitEntity(any(CreateSocieteRequestDto.class));
    }

    @Test
    void testCreateSocietyAndInitEntity_Exception() throws Exception {
        // Given
        CreateSocieteRequestDto requestDto = new CreateSocieteRequestDto(
            "Test Company",
            "Test Activity",
            "Test Address",
            "BP 123",
            "Cameroon",
            "Centre",
            "123456789",
            "NC123",
            "RCCM123",
            "Normal",
            "XAF",
            "logo.png",
            "favicon.ico"
        );

        when(superAdminService.createSocietyAndInitEntity(any(CreateSocieteRequestDto.class)))
            .thenThrow(new RuntimeException("Database connection error"));

        // When & Then
        mockMvc.perform(post("/api/super-admin/create-society-and-init")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Error occurred while creating society: Database connection error"));

        verify(superAdminService, times(1)).createSocietyAndInitEntity(any(CreateSocieteRequestDto.class));
    }
}