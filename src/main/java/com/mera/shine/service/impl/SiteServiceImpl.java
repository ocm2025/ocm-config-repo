package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateSiteRequestDto;
import com.mera.shine.dto.response.SiteDto;
import com.mera.shine.entity.Site;
import com.mera.shine.mapper.SiteMapper;
import com.mera.shine.repository.SiteRepository;
import com.mera.shine.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the SiteService interface.
 */
@Service
@Transactional
public  class SiteServiceImpl implements SiteService {

    private final SiteRepository siteRepository;
    private final SiteMapper siteMapper;

    @Autowired
    public SiteServiceImpl(SiteRepository siteRepository, SiteMapper siteMapper) {
        this.siteRepository = siteRepository;
        this.siteMapper = siteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SiteDto> findAll() {
        return siteRepository.findAll().stream()
                .map(siteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SiteDto> findById(Integer id) {
        return siteRepository.findById(id)
                .map(siteMapper::toDto);
    }

    @Override
    @Transactional
    public SiteDto create(CreateSiteRequestDto createSiteDto) {
        Site site = siteMapper.createDtoToEntity(createSiteDto);
        site = siteRepository.save(site);
        return siteMapper.toDto(site);
    }

    @Override
    @Transactional
    public SiteDto update(Integer id, SiteDto siteDto) {
        return siteRepository.findById(id)
                .map(existingSite -> {
                    Site updatedSite = siteMapper.updateEntityFromDto(siteDto, existingSite);
                    updatedSite = siteRepository.save(updatedSite);
                    return siteMapper.toDto(updatedSite);
                })
                .orElseThrow(() -> new RuntimeException("Site not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        siteRepository.deleteById(id);
    }
}