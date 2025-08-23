package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateModepaiementToSiteRequestDto;
import com.mera.shine.dto.response.ModepaiementToSiteDto;
import com.mera.shine.entity.ModePaiement;
import com.mera.shine.entity.ModepaiementToSite;
import com.mera.shine.entity.Site;
import com.mera.shine.mapper.ModepaiementToSiteMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the ModepaiementToSiteMapper interface.
 */
@Component
public class ModepaiementToSiteMapperImpl implements ModepaiementToSiteMapper {

    @Override
    public ModepaiementToSiteDto toDto(ModepaiementToSite entity) {
        if (entity == null) {
            return null;
        }

        Integer modepaiementId = null;
        if (entity.getModepaiement() != null) {
            modepaiementId = entity.getModepaiement().getId();
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        return new ModepaiementToSiteDto(
                entity.getId(),
                modepaiementId,
                siteId,
                entity.getStatus()
        );
    }

    @Override
    public ModepaiementToSite toEntity(ModepaiementToSiteDto dto) {
        if (dto == null) {
            return null;
        }

        ModepaiementToSite modepaiementToSite = new ModepaiementToSite();
        modepaiementToSite.setId(dto.id());
        modepaiementToSite.setStatus(dto.status());

        if (dto.modepaiementId() != null) {
            ModePaiement modePaiement = new ModePaiement();
            modePaiement.setId(dto.modepaiementId());
            modepaiementToSite.setModepaiement(modePaiement);
        }

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            modepaiementToSite.setSite(site);
        }

        return modepaiementToSite;
    }

    @Override
    public ModepaiementToSite createDtoToEntity(CreateModepaiementToSiteRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        ModepaiementToSite modepaiementToSite = new ModepaiementToSite();
        modepaiementToSite.setStatus(createDto.status());

        if (createDto.modepaiementId() != null) {
            ModePaiement modePaiement = new ModePaiement();
            modePaiement.setId(createDto.modepaiementId());
            modepaiementToSite.setModepaiement(modePaiement);
        }

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            modepaiementToSite.setSite(site);
        }

        return modepaiementToSite;
    }

    @Override
    public ModepaiementToSite updateEntityFromDto(ModepaiementToSiteDto dto, ModepaiementToSite entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setStatus(dto.status());

        if (dto.modepaiementId() != null) {
            if (entity.getModepaiement() == null || !entity.getModepaiement().getId().equals(dto.modepaiementId())) {
                ModePaiement modePaiement = new ModePaiement();
                modePaiement.setId(dto.modepaiementId());
                entity.setModepaiement(modePaiement);
            }
        } else {
            entity.setModepaiement(null);
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