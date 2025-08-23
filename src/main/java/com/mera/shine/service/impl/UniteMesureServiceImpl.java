package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateUniteMesureRequestDto;
import com.mera.shine.dto.response.UniteMesureDto;
import com.mera.shine.entity.UniteMesure;
import com.mera.shine.mapper.UniteMesureMapper;
import com.mera.shine.repository.UniteMesureRepository;
import com.mera.shine.service.UniteMesureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the UniteMesureService interface.
 */
@Service
@Transactional
public class UniteMesureServiceImpl implements UniteMesureService {

    private final UniteMesureRepository uniteMesureRepository;
    private final UniteMesureMapper uniteMesureMapper;

    @Autowired
    public UniteMesureServiceImpl(UniteMesureRepository uniteMesureRepository, UniteMesureMapper uniteMesureMapper) {
        this.uniteMesureRepository = uniteMesureRepository;
        this.uniteMesureMapper = uniteMesureMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UniteMesureDto> findAll() {
        return uniteMesureRepository.findAll().stream()
                .map(uniteMesureMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    @Transactional(readOnly = true)
    public Optional<UniteMesureDto> findById(Integer id) {
        return uniteMesureRepository.findById(id)
                .map(uniteMesureMapper::toDto);
    }



    @Override
    @Transactional
    public UniteMesureDto create(CreateUniteMesureRequestDto createUniteMesureDto) {
        UniteMesure uniteMesure = uniteMesureMapper.createDtoToEntity(createUniteMesureDto);
        uniteMesure = uniteMesureRepository.save(uniteMesure);
        return uniteMesureMapper.toDto(uniteMesure);
    }

    @Override
    @Transactional
    public UniteMesureDto update(Integer id, UniteMesureDto uniteMesureDto) {
        return uniteMesureRepository.findById(id)
                .map(existingUniteMesure -> {
                    UniteMesure updatedUniteMesure = uniteMesureMapper.updateEntityFromDto(uniteMesureDto, existingUniteMesure);
                    updatedUniteMesure = uniteMesureRepository.save(updatedUniteMesure);
                    return uniteMesureMapper.toDto(updatedUniteMesure);
                })
                .orElseThrow(() -> new RuntimeException("UniteMesure not found with id: " + id));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        uniteMesureRepository.deleteById(id);
    }
}