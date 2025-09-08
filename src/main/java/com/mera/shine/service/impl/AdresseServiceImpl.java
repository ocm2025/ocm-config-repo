package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.response.AdresseDto;
import com.mera.shine.entity.Adresse;
import com.mera.shine.mapper.AdresseMapper;
import com.mera.shine.repository.AdresseRepository;
import com.mera.shine.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the AdresseService interface.
 */
@Service
@Transactional
public  class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;
    private final AdresseMapper adresseMapper;

    @Autowired
    public AdresseServiceImpl(AdresseRepository adresseRepository, AdresseMapper adresseMapper) {
        this.adresseRepository = adresseRepository;
        this.adresseMapper = adresseMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdresseDto> findAll() {
        return adresseRepository.findAll().stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AdresseDto> findById(Integer id) {
        return adresseRepository.findById(id)
                .map(adresseMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdresseDto> findByTiersId(Integer tiersId) {
        return adresseRepository.findByTiersId(tiersId).stream()
                .map(adresseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AdresseDto create(CreateAdresseRequestDto createAdresseDto) {
        Adresse adresse = adresseMapper.createDtoToEntity(createAdresseDto);
        adresse = adresseRepository.save(adresse);
        return adresseMapper.toDto(adresse);
    }

    @Override
    @Transactional
    public AdresseDto update(Integer id, AdresseDto adresseDto) {
        return adresseRepository.findById(id)
                .map(existingAdresse -> {
                    Adresse updatedAdresse = adresseMapper.updateEntityFromDto(adresseDto, existingAdresse);
                    updatedAdresse = adresseRepository.save(updatedAdresse);
                    return adresseMapper.toDto(updatedAdresse);
                })
                .orElseThrow(() -> new RuntimeException("Adresse not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        adresseRepository.deleteById(id);
    }
}
