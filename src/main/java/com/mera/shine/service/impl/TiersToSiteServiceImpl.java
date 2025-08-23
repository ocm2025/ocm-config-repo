package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateTiersToSiteRequestDto;
import com.mera.shine.dto.response.TiersToSiteDto;
import com.mera.shine.entity.TiersToSite;
import com.mera.shine.mapper.TiersToSiteMapper;
import com.mera.shine.repository.TiersToSiteRepository;
import com.mera.shine.service.TiersToSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the TiersToSiteService interface.
 */
@Service
@Transactional
public class TiersToSiteServiceImpl implements TiersToSiteService {

    private final TiersToSiteRepository tiersToSiteRepository;
    private final TiersToSiteMapper tiersToSiteMapper;

    @Autowired
    public TiersToSiteServiceImpl(TiersToSiteRepository tiersToSiteRepository, TiersToSiteMapper tiersToSiteMapper) {
        this.tiersToSiteRepository = tiersToSiteRepository;
        this.tiersToSiteMapper = tiersToSiteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TiersToSiteDto> findAll() {
        return tiersToSiteRepository.findAll().stream()
                .map(tiersToSiteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TiersToSiteDto> findById(Integer id) {
        return tiersToSiteRepository.findById(id)
                .map(tiersToSiteMapper::toDto);
    }

    @Override
    @Transactional
    public TiersToSiteDto create(CreateTiersToSiteRequestDto createTiersToSiteDto) {
        TiersToSite tiersToSite = tiersToSiteMapper.createDtoToEntity(createTiersToSiteDto);
        tiersToSite = tiersToSiteRepository.save(tiersToSite);
        return tiersToSiteMapper.toDto(tiersToSite);
    }

    @Override
    @Transactional
    public TiersToSiteDto update(Integer id, TiersToSiteDto tiersToSiteDto) {
        return tiersToSiteRepository.findById(id)
                .map(existingTiersToSite -> {
                    TiersToSite updatedTiersToSite = tiersToSiteMapper.updateEntityFromDto(tiersToSiteDto, existingTiersToSite);
                    updatedTiersToSite = tiersToSiteRepository.save(updatedTiersToSite);
                    return tiersToSiteMapper.toDto(updatedTiersToSite);
                })
                .orElseThrow(() -> new RuntimeException("TiersToSite not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        tiersToSiteRepository.deleteById(id);
    }
}