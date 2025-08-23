package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.SocieteDto;
import com.mera.shine.entity.Parametre;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.SocieteMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the SocieteMapper interface.
 */
@Component
public class SocieteMapperImpl implements SocieteMapper {

    @Override
    public SocieteDto toDto(Societe entity) {
        if (entity == null) {
            return null;
        }

        Set<Integer> parametreIds = null;
        if (entity.getParametres() != null) {
            parametreIds = entity.getParametres().stream()
                    .map(Parametre::getId)
                    .collect(Collectors.toSet());
        }

        return new SocieteDto(
                entity.getId(),
                entity.getSNom(),
                entity.getSActivite(),
                entity.getSAdresse(),
                entity.getSBoitePostal(),
                entity.getSPays(),
                entity.getSRegion(),
                entity.getSTelephone(),
                entity.getSNc(),
                entity.getSRccm(),
                entity.getSRegimeFiscal(),
                entity.getSDevise(),
                entity.getSLogo(),
                entity.getSFovicon(),
                parametreIds
        );
    }

    @Override
    public Societe toEntity(SocieteDto dto) {
        if (dto == null) {
            return null;
        }

        Societe societe = new Societe();
        societe.setId(dto.id());
        societe.setSNom(dto.sNom());
        societe.setSActivite(dto.sActivite());
        societe.setSAdresse(dto.sAdresse());
        societe.setSBoitePostal(dto.sBoitePostal());
        societe.setSPays(dto.sPays());
        societe.setSRegion(dto.sRegion());
        societe.setSTelephone(dto.sTelephone());
        societe.setSNc(dto.sNc());
        societe.setSRccm(dto.sRccm());
        societe.setSRegimeFiscal(dto.sRegimeFiscal());
        societe.setSDevise(dto.sDevise());
        societe.setSLogo(dto.sLogo());
        societe.setSFovicon(dto.sFovicon());

        // We don't set parametres here as it's a one-to-many relationship
        // and would require loading the actual Parametre entities

        return societe;
    }

    @Override
    public Societe createDtoToEntity(CreateSocieteRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Societe societe = new Societe();
        societe.setSNom(createDto.sNom());
        societe.setSActivite(createDto.sActivite());
        societe.setSAdresse(createDto.sAdresse());
        societe.setSBoitePostal(createDto.sBoitePostal());
        societe.setSPays(createDto.sPays());
        societe.setSRegion(createDto.sRegion());
        societe.setSTelephone(createDto.sTelephone());
        societe.setSNc(createDto.sNc());
        societe.setSRccm(createDto.sRccm());
        societe.setSRegimeFiscal(createDto.sRegimeFiscal());
        societe.setSDevise(createDto.sDevise());
        societe.setSLogo(createDto.sLogo());
        societe.setSFovicon(createDto.sFovicon());

        societe.setParametres(new HashSet<>());

        return societe;
    }

    @Override
    public Societe updateEntityFromDto(SocieteDto dto, Societe entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setSNom(dto.sNom());
        entity.setSActivite(dto.sActivite());
        entity.setSAdresse(dto.sAdresse());
        entity.setSBoitePostal(dto.sBoitePostal());
        entity.setSPays(dto.sPays());
        entity.setSRegion(dto.sRegion());
        entity.setSTelephone(dto.sTelephone());
        entity.setSNc(dto.sNc());
        entity.setSRccm(dto.sRccm());
        entity.setSRegimeFiscal(dto.sRegimeFiscal());
        entity.setSDevise(dto.sDevise());
        entity.setSLogo(dto.sLogo());
        entity.setSFovicon(dto.sFovicon());

        // We don't update parametres here as it's a one-to-many relationship
        // and would require loading the actual Parametre entities

        return entity;
    }
}