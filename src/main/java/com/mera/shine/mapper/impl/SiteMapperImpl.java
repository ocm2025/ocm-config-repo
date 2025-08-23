package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateSiteRequestDto;
import com.mera.shine.dto.response.SiteDto;
import com.mera.shine.entity.Emplacement;
import com.mera.shine.entity.Parametre;
import com.mera.shine.entity.Site;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.SiteMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the SiteMapper interface.
 */
@Component
public class SiteMapperImpl implements SiteMapper {

    @Override
    public SiteDto toDto(Site entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        Set<Integer> emplacementIds = null;
        if (entity.getEmplacements() != null) {
            emplacementIds = entity.getEmplacements().stream()
                    .map(Emplacement::getId)
                    .collect(Collectors.toSet());
        }

        Set<Integer> parametreIds = null;
        if (entity.getParametres() != null) {
            parametreIds = entity.getParametres().stream()
                    .map(Parametre::getId)
                    .collect(Collectors.toSet());
        }

        return new SiteDto(
                entity.getId(),
                entity.getPvNom(),
                entity.getPvCode(),
                entity.getPvDescription(),
                entity.getPvVille(),
                entity.getPvPays(),
                entity.getPvGetEmplacement(),
                societeId,
                emplacementIds,
                parametreIds
        );
    }

    @Override
    public Site toEntity(SiteDto dto) {
        if (dto == null) {
            return null;
        }

        Site site = new Site();
        site.setId(dto.id());
        site.setPvNom(dto.pvNom());
        site.setPvCode(dto.pvCode());
        site.setPvDescription(dto.pvDescription());
        site.setPvVille(dto.pvVille());
        site.setPvPays(dto.pvPays());
        site.setPvGetEmplacement(dto.pvGetEmplacement());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            site.setSociete(societe);
        }

        // We don't set emplacements and parametres here as they are one-to-many relationships
        // and would require loading the actual entities

        return site;
    }

    @Override
    public Site createDtoToEntity(CreateSiteRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Site site = new Site();
        site.setPvNom(createDto.pvNom());
        site.setPvCode(createDto.pvCode());
        site.setPvDescription(createDto.pvDescription());
        site.setPvVille(createDto.pvVille());
        site.setPvPays(createDto.pvPays());
        site.setPvGetEmplacement(createDto.pvGetEmplacement());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            site.setSociete(societe);
        }

        site.setEmplacements(new HashSet<>());
        site.setParametres(new HashSet<>());

        return site;
    }

    @Override
    public Site updateEntityFromDto(SiteDto dto, Site entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setPvNom(dto.pvNom());
        entity.setPvCode(dto.pvCode());
        entity.setPvDescription(dto.pvDescription());
        entity.setPvVille(dto.pvVille());
        entity.setPvPays(dto.pvPays());
        entity.setPvGetEmplacement(dto.pvGetEmplacement());

        if (dto.societeId() != null) {
            if (entity.getSociete() == null || !entity.getSociete().getId().equals(dto.societeId())) {
                Societe societe = new Societe();
                societe.setId(dto.societeId());
                entity.setSociete(societe);
            }
        } else {
            entity.setSociete(null);
        }

        // We don't update emplacements and parametres here as they are one-to-many relationships
        // and would require loading the actual entities

        return entity;
    }
}