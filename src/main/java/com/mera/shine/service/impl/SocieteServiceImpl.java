package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateSocieteRequestDto;
import com.mera.shine.dto.response.SocieteDto;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.SocieteMapper;
import com.mera.shine.repository.SocieteRepository;
import com.mera.shine.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the SocieteService interface.
 */
@Service
@Transactional
public  class SocieteServiceImpl implements SocieteService {

    private final SocieteRepository societeRepository;
    private final SocieteMapper societeMapper;

    @Autowired
    public SocieteServiceImpl(SocieteRepository societeRepository, SocieteMapper societeMapper) {
        this.societeRepository = societeRepository;
        this.societeMapper = societeMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SocieteDto> findAll() {
        return societeRepository.findAll().stream()
                .map(societeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SocieteDto> findById(Integer id) {
        return societeRepository.findById(id)
                .map(societeMapper::toDto);
    }

    @Override
    @Transactional
    public SocieteDto create(CreateSocieteRequestDto createSocieteDto) {
        Societe societe = societeMapper.createDtoToEntity(createSocieteDto);
        societe = societeRepository.save(societe);
        return societeMapper.toDto(societe);
    }

    @Override
    @Transactional
    public SocieteDto update(Integer id, SocieteDto societeDto) {
        return societeRepository.findById(id)
                .map(existingSociete -> {
                    Societe updatedSociete = societeMapper.updateEntityFromDto(societeDto, existingSociete);
                    updatedSociete = societeRepository.save(updatedSociete);
                    return societeMapper.toDto(updatedSociete);
                })
                .orElseThrow(() -> new RuntimeException("Societe not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        societeRepository.deleteById(id);
    }
}