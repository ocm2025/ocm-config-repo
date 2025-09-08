package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateZoneDistributionRequestDto;
import com.mera.shine.dto.response.ZoneDistributionDto;
import com.mera.shine.entity.ZoneDistribution;
import com.mera.shine.mapper.ZoneDistributionMapper;
import com.mera.shine.repository.ZoneDistributionRepository;
import com.mera.shine.service.ZoneDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the ZoneDistributionService interface.
 */
@Service
@Transactional
public  class ZoneDistributionServiceImpl implements ZoneDistributionService {

    private final ZoneDistributionRepository zoneDistributionRepository;
    private final ZoneDistributionMapper zoneDistributionMapper;

    @Autowired
    public ZoneDistributionServiceImpl(ZoneDistributionRepository zoneDistributionRepository, ZoneDistributionMapper zoneDistributionMapper) {
        this.zoneDistributionRepository = zoneDistributionRepository;
        this.zoneDistributionMapper = zoneDistributionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ZoneDistributionDto> findAll() {
        return zoneDistributionRepository.findAll().stream()
                .map(zoneDistributionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ZoneDistributionDto> findById(Integer id) {
        return zoneDistributionRepository.findById(id)
                .map(zoneDistributionMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ZoneDistributionDto> findBySiteId(Integer siteId) {
        return zoneDistributionRepository.findBySiteId(siteId).stream()
                .map(zoneDistributionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ZoneDistributionDto create(CreateZoneDistributionRequestDto createZoneDistributionDto) {
        ZoneDistribution zoneDistribution = zoneDistributionMapper.createDtoToEntity(createZoneDistributionDto);
        zoneDistribution = zoneDistributionRepository.save(zoneDistribution);
        return zoneDistributionMapper.toDto(zoneDistribution);
    }

    @Override
    @Transactional
    public ZoneDistributionDto update(Integer id, ZoneDistributionDto zoneDistributionDto) {
        return zoneDistributionRepository.findById(id)
                .map(existingZoneDistribution -> {
                    ZoneDistribution updatedZoneDistribution = zoneDistributionMapper.updateEntityFromDto(zoneDistributionDto, existingZoneDistribution);
                    updatedZoneDistribution = zoneDistributionRepository.save(updatedZoneDistribution);
                    return zoneDistributionMapper.toDto(updatedZoneDistribution);
                })
                .orElseThrow(() -> new RuntimeException("ZoneDistribution not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        zoneDistributionRepository.deleteById(id);
    }
}
