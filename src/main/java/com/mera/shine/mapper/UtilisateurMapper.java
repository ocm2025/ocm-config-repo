package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateUtilisateurRequestDto;
import com.mera.shine.dto.response.UtilisateurDto;
import com.mera.shine.entity.Utilisateur;

/**
 * Mapper for the Utilisateur entity and its DTOs.
 */
public interface UtilisateurMapper extends EntityMapper<Utilisateur, UtilisateurDto, CreateUtilisateurRequestDto> {
}