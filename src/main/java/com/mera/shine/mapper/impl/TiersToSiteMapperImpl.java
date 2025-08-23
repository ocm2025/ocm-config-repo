package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateTiersToSiteRequestDto;
import com.mera.shine.dto.response.TiersToSiteDto;
import com.mera.shine.entity.Site;
import com.mera.shine.entity.Tier;
import com.mera.shine.entity.TiersToSite;
import com.mera.shine.mapper.TiersToSiteMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the TiersToSiteMapper interface.
 */
@Component
public class TiersToSiteMapperImpl implements TiersToSiteMapper {

    @Override
    public TiersToSiteDto toDto(TiersToSite entity) {
        if (entity == null) {
            return null;
        }

        Integer tiersId = null;
        if (entity.getTiers() != null) {
            tiersId = entity.getTiers().getId();
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        return new TiersToSiteDto(
                entity.getId(),
                tiersId,
                siteId,
                entity.getStatus()
        );
    }

    @Override
    public TiersToSite toEntity(TiersToSiteDto dto) {
        if (dto == null) {
            return null;
        }

        TiersToSite tiersToSite = new TiersToSite();
        tiersToSite.setId(dto.id());
        tiersToSite.setStatus(dto.status());

        if (dto.tiersId() != null) {
            Tier tier = new Tier();
            tier.setId(dto.tiersId());
            tiersToSite.setTiers(tier);
        }

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            tiersToSite.setSite(site);
        }

        return tiersToSite;
    }

    @Override
    public TiersToSite createDtoToEntity(CreateTiersToSiteRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        TiersToSite tiersToSite = new TiersToSite();
        tiersToSite.setStatus(createDto.status());

        if (createDto.tiersId() != null) {
            Tier tier = new Tier();
            tier.setId(createDto.tiersId());
            tiersToSite.setTiers(tier);
        }

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            tiersToSite.setSite(site);
        }

        return tiersToSite;
    }

    @Override
    public TiersToSite updateEntityFromDto(TiersToSiteDto dto, TiersToSite entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setStatus(dto.status());

        if (dto.tiersId() != null) {
            if (entity.getTiers() == null || !entity.getTiers().getId().equals(dto.tiersId())) {
                Tier tier = new Tier();
                tier.setId(dto.tiersId());
                entity.setTiers(tier);
            }
        } else {
            entity.setTiers(null);
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