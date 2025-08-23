package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.SocieteDto;
import com.mera.shine.entity.Societe;

/**
 * Mapper for the Societe entity and its DTOs.
 */
public interface SocieteMapper extends EntityMapper<Societe, SocieteDto, CreateSocieteRequestDto> {
}