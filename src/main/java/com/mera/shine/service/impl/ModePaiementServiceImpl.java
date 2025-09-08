package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateModePaiementRequestDto;
import com.mera.shine.dto.response.ModePaiementDto;
import com.mera.shine.entity.ModePaiement;
import com.mera.shine.mapper.ModePaiementMapper;
import com.mera.shine.repository.ModePaiementRepository;
import com.mera.shine.service.ModePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the ModePaiementService interface.
 */
@Service
@Transactional
public  class ModePaiementServiceImpl implements ModePaiementService {

    private final ModePaiementRepository modePaiementRepository;
    private final ModePaiementMapper modePaiementMapper;

    @Autowired
    public ModePaiementServiceImpl(ModePaiementRepository modePaiementRepository, ModePaiementMapper modePaiementMapper) {
        this.modePaiementRepository = modePaiementRepository;
        this.modePaiementMapper = modePaiementMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModePaiementDto> findAll() {
        return modePaiementRepository.findAll().stream()
                .map(modePaiementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ModePaiementDto> findById(Integer id) {
        return modePaiementRepository.findById(id)
                .map(modePaiementMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ModePaiementDto> findBySocieteId(Integer societeId) {
        return modePaiementRepository.findBySocieteId(societeId).stream()
                .map(modePaiementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ModePaiementDto create(CreateModePaiementRequestDto createModePaiementDto) {
        ModePaiement modePaiement = modePaiementMapper.createDtoToEntity(createModePaiementDto);
        modePaiement = modePaiementRepository.save(modePaiement);
        return modePaiementMapper.toDto(modePaiement);
    }

    @Override
    @Transactional
    public ModePaiementDto update(Integer id, ModePaiementDto modePaiementDto) {
        return modePaiementRepository.findById(id)
                .map(existingModePaiement -> {
                    ModePaiement updatedModePaiement = modePaiementMapper.updateEntityFromDto(modePaiementDto, existingModePaiement);
                    updatedModePaiement = modePaiementRepository.save(updatedModePaiement);
                    return modePaiementMapper.toDto(updatedModePaiement);
                })
                .orElseThrow(() -> new RuntimeException("ModePaiement not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        modePaiementRepository.deleteById(id);
    }
}
