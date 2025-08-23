package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.response.AdresseDto;
import com.mera.shine.entity.Adresse;

/**
 * Mapper for the Adresse entity and its DTOs.
 */
public interface AdresseMapper extends EntityMapper<Adresse, AdresseDto, CreateAdresseRequestDto> {
}