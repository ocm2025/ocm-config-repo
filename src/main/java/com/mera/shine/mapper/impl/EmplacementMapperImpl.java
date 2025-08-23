package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateEmplacementRequestDto;
import com.mera.shine.dto.response.EmplacementDto;
import com.mera.shine.entity.Emplacement;
import com.mera.shine.entity.Site;
import com.mera.shine.mapper.EmplacementMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the EmplacementMapper interface.
 */
@Component
public class EmplacementMapperImpl implements EmplacementMapper {

    @Override
    public EmplacementDto toDto(Emplacement entity) {
        if (entity == null) {
            return null;
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        return new EmplacementDto(
                entity.getId(),
                entity.getEmNom(),
                entity.getEmCode(),
                siteId
        );
    }

    @Override
    public Emplacement toEntity(EmplacementDto dto) {
        if (dto == null) {
            return null;
        }

        Emplacement emplacement = new Emplacement();
        emplacement.setId(dto.id());
        emplacement.setEmNom(dto.emNom());
        emplacement.setEmCode(dto.emCode());

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            emplacement.setSite(site);
        }

        return emplacement;
    }

    @Override
    public Emplacement createDtoToEntity(CreateEmplacementRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Emplacement emplacement = new Emplacement();
        emplacement.setEmNom(createDto.emNom());
        emplacement.setEmCode(createDto.emCode());

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            emplacement.setSite(site);
        }

        return emplacement;
    }

    @Override
    public Emplacement updateEntityFromDto(EmplacementDto dto, Emplacement entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setEmNom(dto.emNom());
        entity.setEmCode(dto.emCode());

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