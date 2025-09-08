package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateEmplacementRequestDto;
import com.mera.shine.dto.response.EmplacementDto;
import com.mera.shine.entity.Emplacement;
import com.mera.shine.mapper.EmplacementMapper;
import com.mera.shine.repository.EmplacementRepository;
import com.mera.shine.service.EmplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the EmplacementService interface.
 */
@Service
@Transactional
public  class EmplacementServiceImpl implements EmplacementService {

    private final EmplacementRepository emplacementRepository;
    private final EmplacementMapper emplacementMapper;

    @Autowired
    public EmplacementServiceImpl(EmplacementRepository emplacementRepository, EmplacementMapper emplacementMapper) {
        this.emplacementRepository = emplacementRepository;
        this.emplacementMapper = emplacementMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmplacementDto> findAll() {
        return emplacementRepository.findAll().stream()
                .map(emplacementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmplacementDto> findBySocieteId(Integer societeId) {
        return emplacementRepository.findBySocieteId(societeId).stream()
                .map(emplacementMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmplacementDto> findBySiteId(Integer siteId) {
        return emplacementRepository.findBySiteId(siteId).stream()
                .map(emplacementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<EmplacementDto> findById(Integer id) {
        return emplacementRepository.findById(id)
                .map(emplacementMapper::toDto);
    }


    @Override
    @Transactional
    public EmplacementDto create(CreateEmplacementRequestDto createEmplacementDto) {
        Emplacement emplacement = emplacementMapper.createDtoToEntity(createEmplacementDto);
        emplacement = emplacementRepository.save(emplacement);
        return emplacementMapper.toDto(emplacement);
    }

    @Override
    @Transactional
    public EmplacementDto update(Integer id, EmplacementDto emplacementDto) {
        return emplacementRepository.findById(id)
                .map(existingEmplacement -> {
                    Emplacement updatedEmplacement = emplacementMapper.updateEntityFromDto(emplacementDto, existingEmplacement);
                    updatedEmplacement = emplacementRepository.save(updatedEmplacement);
                    return emplacementMapper.toDto(updatedEmplacement);
                })
                .orElseThrow(() -> new RuntimeException("Emplacement not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        emplacementRepository.deleteById(id);
    }
}
