package com.mera.shine.service;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.AdresseDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Adresse entities.
 */
public interface SuperAdminService {

    boolean createSocietyAndInitEntity(CreateSocieteRequestDto societeRequestDto);
    

}