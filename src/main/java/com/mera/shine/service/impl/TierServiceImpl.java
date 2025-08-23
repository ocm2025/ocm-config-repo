package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateTierRequestDto;
import com.mera.shine.dto.response.TierDto;
import com.mera.shine.entity.Tier;
import com.mera.shine.mapper.TierMapper;
import com.mera.shine.repository.TierRepository;
import com.mera.shine.service.TierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the TierService interface.
 */
@Service
@Transactional
public  class TierServiceImpl implements TierService {

    private final TierRepository tierRepository;
    private final TierMapper tierMapper;

    @Autowired
    public TierServiceImpl(TierRepository tierRepository, TierMapper tierMapper) {
        this.tierRepository = tierRepository;
        this.tierMapper = tierMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TierDto> findAll() {
        return tierRepository.findAll().stream()
                .map(tierMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TierDto> findById(Integer id) {
        return tierRepository.findById(id)
                .map(tierMapper::toDto);
    }


    @Override
    @Transactional
    public TierDto create(CreateTierRequestDto createTierDto) {
        Tier tier = tierMapper.createDtoToEntity(createTierDto);
        tier = tierRepository.save(tier);
        return tierMapper.toDto(tier);
    }

    @Override
    @Transactional
    public TierDto update(Integer id, TierDto tierDto) {
        return tierRepository.findById(id)
                .map(existingTier -> {
                    Tier updatedTier = tierMapper.updateEntityFromDto(tierDto, existingTier);
                    updatedTier = tierRepository.save(updatedTier);
                    return tierMapper.toDto(updatedTier);
                })
                .orElseThrow(() -> new RuntimeException("Tier not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        tierRepository.deleteById(id);
    }
}