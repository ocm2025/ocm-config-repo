package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateSiteRequestDto;
import com.mera.shine.dto.response.SiteDto;
import com.mera.shine.entity.Site;

/**
 * Mapper for the Site entity and its DTOs.
 */
public interface SiteMapper extends EntityMapper<Site, SiteDto, CreateSiteRequestDto> {
}