package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateModepaiementToSiteRequestDto;
import com.mera.shine.dto.response.ModepaiementToSiteDto;
import com.mera.shine.entity.ModepaiementToSite;
import com.mera.shine.mapper.ModepaiementToSiteMapper;
import com.mera.shine.repository.ModepaiementToSiteRepository;
import com.mera.shine.service.ModepaiementToSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the ModepaiementToSiteService interface.
 */
@Service
@Transactional
public class ModepaiementToSiteServiceImpl implements ModepaiementToSiteService {

    private final ModepaiementToSiteRepository modepaiementToSiteRepository;
    private final ModepaiementToSiteMapper modepaiementToSiteMapper;

    @Autowired
    public ModepaiementToSiteServiceImpl(ModepaiementToSiteRepository modepaiementToSiteRepository, ModepaiementToSiteMapper modepaiementToSiteMapper) {
        this.modepaiementToSiteRepository = modepaiementToSiteRepository;
        this.modepaiementToSiteMapper = modepaiementToSiteMapper;
    }

    @Transactional(readOnly = true)
    public List<ModepaiementToSiteDto> findAll() {
        return modepaiementToSiteRepository.findAll().stream()
                .map(modepaiementToSiteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ModepaiementToSiteDto> findById(Integer id) {
        return modepaiementToSiteRepository.findById(id)
                .map(modepaiementToSiteMapper::toDto);
    }

    @Transactional
    public ModepaiementToSiteDto create(CreateModepaiementToSiteRequestDto createModepaiementToSiteDto) {
        ModepaiementToSite modepaiementToSite = modepaiementToSiteMapper.createDtoToEntity(createModepaiementToSiteDto);
        modepaiementToSite = modepaiementToSiteRepository.save(modepaiementToSite);
        return modepaiementToSiteMapper.toDto(modepaiementToSite);
    }

    @Transactional
    public ModepaiementToSiteDto update(Integer id, ModepaiementToSiteDto modepaiementToSiteDto) {
        return modepaiementToSiteRepository.findById(id)
                .map(existingModepaiementToSite -> {
                    ModepaiementToSite updatedModepaiementToSite = modepaiementToSiteMapper.updateEntityFromDto(modepaiementToSiteDto, existingModepaiementToSite);
                    updatedModepaiementToSite = modepaiementToSiteRepository.save(updatedModepaiementToSite);
                    return modepaiementToSiteMapper.toDto(updatedModepaiementToSite);
                })
                .orElseThrow(() -> new RuntimeException("ModepaiementToSite not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        modepaiementToSiteRepository.deleteById(id);
    }
}
