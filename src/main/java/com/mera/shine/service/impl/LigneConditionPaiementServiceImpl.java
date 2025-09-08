package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateLigneConditionPaiementRequestDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;
import com.mera.shine.entity.LigneConditionPaiement;
import com.mera.shine.mapper.LigneConditionPaiementMapper;
import com.mera.shine.repository.LigneConditionPaiementRepository;
import com.mera.shine.service.LigneConditionPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the LigneConditionPaiementService interface.
 */
@Service
@Transactional
public class LigneConditionPaiementServiceImpl implements LigneConditionPaiementService {

    private final LigneConditionPaiementRepository ligneConditionPaiementRepository;
    private final LigneConditionPaiementMapper ligneConditionPaiementMapper;

    @Autowired
    public LigneConditionPaiementServiceImpl(LigneConditionPaiementRepository ligneConditionPaiementRepository, 
                                            LigneConditionPaiementMapper ligneConditionPaiementMapper) {
        this.ligneConditionPaiementRepository = ligneConditionPaiementRepository;
        this.ligneConditionPaiementMapper = ligneConditionPaiementMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LigneConditionPaiementDto> findAll() {
        return ligneConditionPaiementRepository.findAll().stream()
                .map(ligneConditionPaiementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<LigneConditionPaiementDto> findById(Integer id) {
        return ligneConditionPaiementRepository.findById(id)
                .map(ligneConditionPaiementMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LigneConditionPaiementDto> findBySocieteId(Integer societeId) {
        return ligneConditionPaiementRepository.findBySocieteId(societeId).stream()
                .map(ligneConditionPaiementMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public LigneConditionPaiementDto create(CreateLigneConditionPaiementRequestDto createLigneConditionPaiementDto) {
        LigneConditionPaiement ligneConditionPaiement = ligneConditionPaiementMapper.createDtoToEntity(createLigneConditionPaiementDto);
        ligneConditionPaiement = ligneConditionPaiementRepository.save(ligneConditionPaiement);
        return ligneConditionPaiementMapper.toDto(ligneConditionPaiement);
    }

    @Override
    @Transactional
    public LigneConditionPaiementDto update(Integer id, LigneConditionPaiementDto ligneConditionPaiementDto) {
        return ligneConditionPaiementRepository.findById(id)
                .map(existingLigneConditionPaiement -> {
                    LigneConditionPaiement updatedLigneConditionPaiement = ligneConditionPaiementMapper.updateEntityFromDto(ligneConditionPaiementDto, existingLigneConditionPaiement);
                    updatedLigneConditionPaiement = ligneConditionPaiementRepository.save(updatedLigneConditionPaiement);
                    return ligneConditionPaiementMapper.toDto(updatedLigneConditionPaiement);
                })
                .orElseThrow(() -> new RuntimeException("LigneConditionPaiement not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ligneConditionPaiementRepository.deleteById(id);
    }
}
