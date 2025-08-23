package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateLanguageRequestDto;
import com.mera.shine.dto.response.LanguageDto;
import com.mera.shine.entity.Language;
import com.mera.shine.mapper.LanguageMapper;
import com.mera.shine.repository.LanguageRepository;
import com.mera.shine.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the LanguageService interface.
 */
@Service
@Transactional
public  class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<LanguageDto> findAll() {
        return languageRepository.findAll().stream()
                .map(languageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LanguageDto> findById(Integer id) {
        return languageRepository.findById(id)
                .map(languageMapper::toDto);
    }


    @Override
    @Transactional
    public LanguageDto create(CreateLanguageRequestDto createLanguageDto) {
        Language language = languageMapper.createDtoToEntity(createLanguageDto);
        language = languageRepository.save(language);
        return languageMapper.toDto(language);
    }

    @Override
    @Transactional
    public LanguageDto update(Integer id, LanguageDto languageDto) {
        return languageRepository.findById(id)
                .map(existingLanguage -> {
                    Language updatedLanguage = languageMapper.updateEntityFromDto(languageDto, existingLanguage);
                    updatedLanguage = languageRepository.save(updatedLanguage);
                    return languageMapper.toDto(updatedLanguage);
                })
                .orElseThrow(() -> new RuntimeException("Language not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        languageRepository.deleteById(id);
    }
}