package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateZoneDistributionRequestDto;
import com.mera.shine.dto.response.ZoneDistributionDto;
import com.mera.shine.entity.Site;
import com.mera.shine.entity.ZoneDistribution;
import com.mera.shine.mapper.ZoneDistributionMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the ZoneDistributionMapper interface.
 */
@Component
public class ZoneDistributionMapperImpl implements ZoneDistributionMapper {

    @Override
    public ZoneDistributionDto toDto(ZoneDistribution entity) {
        if (entity == null) {
            return null;
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        return new ZoneDistributionDto(
                entity.getId(),
                entity.getZdCode(),
                entity.getZdLibelle(),
                siteId
        );
    }

    @Override
    public ZoneDistribution toEntity(ZoneDistributionDto dto) {
        if (dto == null) {
            return null;
        }

        ZoneDistribution zoneDistribution = new ZoneDistribution();
        zoneDistribution.setId(dto.id());
        zoneDistribution.setZdCode(dto.zdCode());
        zoneDistribution.setZdLibelle(dto.zdLibelle());

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            zoneDistribution.setSite(site);
        }

        return zoneDistribution;
    }

    @Override
    public ZoneDistribution createDtoToEntity(CreateZoneDistributionRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        ZoneDistribution zoneDistribution = new ZoneDistribution();
        zoneDistribution.setZdCode(createDto.zdCode());
        zoneDistribution.setZdLibelle(createDto.zdLibelle());

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            zoneDistribution.setSite(site);
        }

        return zoneDistribution;
    }

    @Override
    public ZoneDistribution updateEntityFromDto(ZoneDistributionDto dto, ZoneDistribution entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setZdCode(dto.zdCode());
        entity.setZdLibelle(dto.zdLibelle());

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