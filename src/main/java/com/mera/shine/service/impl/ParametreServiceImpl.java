package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateParametreRequestDto;
import com.mera.shine.dto.response.ParametreDto;
import com.mera.shine.entity.Parametre;
import com.mera.shine.mapper.ParametreMapper;
import com.mera.shine.repository.ParametreRepository;
import com.mera.shine.service.ParametreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the ParametreService interface.
 */
@Service
@Transactional
public class ParametreServiceImpl implements ParametreService {

    private final ParametreRepository parametreRepository;
    private final ParametreMapper parametreMapper;

    @Autowired
    public ParametreServiceImpl(ParametreRepository parametreRepository, ParametreMapper parametreMapper) {
        this.parametreRepository = parametreRepository;
        this.parametreMapper = parametreMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParametreDto> findAll() {
        return parametreRepository.findAll().stream()
                .map(parametreMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ParametreDto> findById(Integer id) {
        return parametreRepository.findById(id)
                .map(parametreMapper::toDto);
    }

    @Override
    @Transactional
    public ParametreDto create(CreateParametreRequestDto createParametreDto) {
        Parametre parametre = parametreMapper.createDtoToEntity(createParametreDto);
        parametre = parametreRepository.save(parametre);
        return parametreMapper.toDto(parametre);
    }

    @Override
    @Transactional
    public ParametreDto update(Integer id, ParametreDto parametreDto) {
        return parametreRepository.findById(id)
                .map(existingParametre -> {
                    Parametre updatedParametre = parametreMapper.updateEntityFromDto(parametreDto, existingParametre);
                    updatedParametre = parametreRepository.save(updatedParametre);
                    return parametreMapper.toDto(updatedParametre);
                })
                .orElseThrow(() -> new RuntimeException("Parametre not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        parametreRepository.deleteById(id);
    }
}