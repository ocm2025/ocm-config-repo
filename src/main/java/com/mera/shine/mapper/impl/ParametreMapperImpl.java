package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateParametreRequestDto;
import com.mera.shine.dto.response.ParametreDto;
import com.mera.shine.entity.Parametre;
import com.mera.shine.entity.Site;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.ParametreMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the ParametreMapper interface.
 */
@Component
public class ParametreMapperImpl implements ParametreMapper {

    @Override
    public ParametreDto toDto(Parametre entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        return new ParametreDto(
                entity.getId(),
                entity.getCsCode(),
                entity.getCsLibelle(),
                entity.getCsIsValid(),
                entity.getMessage(),
                societeId,
                siteId
        );
    }

    @Override
    public Parametre toEntity(ParametreDto dto) {
        if (dto == null) {
            return null;
        }

        Parametre parametre = new Parametre();
        parametre.setId(dto.id());
        parametre.setCsCode(dto.csCode());
        parametre.setCsLibelle(dto.csLibelle());
        parametre.setCsIsValid(dto.csIsValid());
        parametre.setMessage(dto.message());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            parametre.setSociete(societe);
        }

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            parametre.setSite(site);
        }

        return parametre;
    }

    @Override
    public Parametre createDtoToEntity(CreateParametreRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Parametre parametre = new Parametre();
        parametre.setCsCode(createDto.csCode());
        parametre.setCsLibelle(createDto.csLibelle());
        parametre.setCsIsValid(createDto.csIsValid());
        parametre.setMessage(createDto.message());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            parametre.setSociete(societe);
        }

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            parametre.setSite(site);
        }

        return parametre;
    }

    @Override
    public Parametre updateEntityFromDto(ParametreDto dto, Parametre entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setCsCode(dto.csCode());
        entity.setCsLibelle(dto.csLibelle());
        entity.setCsIsValid(dto.csIsValid());
        entity.setMessage(dto.message());

        if (dto.societeId() != null) {
            if (entity.getSociete() == null || !entity.getSociete().getId().equals(dto.societeId())) {
                Societe societe = new Societe();
                societe.setId(dto.societeId());
                entity.setSociete(societe);
            }
        } else {
            entity.setSociete(null);
        }

        if (dto.siteId() != null) {
            if (entity.getSite() == null || !entity.getSite().getId().equals(dto.siteId())) {
                Site site = new Site();
                site.setId(dto.siteId());
                entity.setSite(site);
            }
        } else {
            entity.setSite(null);
        }

        return entity;
    }
}