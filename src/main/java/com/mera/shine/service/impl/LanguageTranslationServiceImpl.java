package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateLanguageTranslationRequestDto;
import com.mera.shine.dto.response.LanguageTranslationDto;
import com.mera.shine.entity.LanguageTranslation;
import com.mera.shine.mapper.LanguageTranslationMapper;
import com.mera.shine.repository.LanguageTranslationRepository;
import com.mera.shine.service.LanguageTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the LanguageTranslationService interface.
 */
@Service
@Transactional
public  class LanguageTranslationServiceImpl implements LanguageTranslationService {

    private final LanguageTranslationRepository languageTranslationRepository;
    private final LanguageTranslationMapper languageTranslationMapper;

    @Autowired
    public LanguageTranslationServiceImpl(LanguageTranslationRepository languageTranslationRepository, 
                                         LanguageTranslationMapper languageTranslationMapper) {
        this.languageTranslationRepository = languageTranslationRepository;
        this.languageTranslationMapper = languageTranslationMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LanguageTranslationDto> findAll() {
        return languageTranslationRepository.findAll().stream()
                .map(languageTranslationMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<LanguageTranslationDto> findById(Integer id) {
        return languageTranslationRepository.findById(id)
                .map(languageTranslationMapper::toDto);
    }

    @Override
    @Transactional
    public LanguageTranslationDto create(CreateLanguageTranslationRequestDto createLanguageTranslationDto) {
        LanguageTranslation languageTranslation = languageTranslationMapper.createDtoToEntity(createLanguageTranslationDto);
        languageTranslation = languageTranslationRepository.save(languageTranslation);
        return languageTranslationMapper.toDto(languageTranslation);
    }

    @Override
    @Transactional
    public LanguageTranslationDto update(Integer id, LanguageTranslationDto languageTranslationDto) {
        return languageTranslationRepository.findById(id)
                .map(existingTranslation -> {
                    LanguageTranslation updatedTranslation = languageTranslationMapper.updateEntityFromDto(languageTranslationDto, existingTranslation);
                    updatedTranslation = languageTranslationRepository.save(updatedTranslation);
                    return languageTranslationMapper.toDto(updatedTranslation);
                })
                .orElseThrow(() -> new RuntimeException("LanguageTranslation not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        languageTranslationRepository.deleteById(id);
    }
}