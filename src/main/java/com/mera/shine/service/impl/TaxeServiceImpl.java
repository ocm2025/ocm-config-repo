package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateTaxeRequestDto;
import com.mera.shine.dto.response.TaxeDto;
import com.mera.shine.entity.Taxe;
import com.mera.shine.mapper.TaxeMapper;
import com.mera.shine.repository.TaxeRepository;
import com.mera.shine.service.TaxeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the TaxeService interface.
 */
@Service
@Transactional
public class TaxeServiceImpl  implements  TaxeService {

    private final TaxeRepository taxeRepository;
    private final TaxeMapper taxeMapper;

    @Autowired
    public TaxeServiceImpl(TaxeRepository taxeRepository, TaxeMapper taxeMapper) {
        this.taxeRepository = taxeRepository;
        this.taxeMapper = taxeMapper;
    }

    @Transactional(readOnly = true)
    public List<TaxeDto> findAll() {
        return taxeRepository.findAll().stream()
                .map(taxeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<TaxeDto> findById(Integer id) {
        return taxeRepository.findById(id)
                .map(taxeMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<TaxeDto> findBySocieteId(Integer societeId) {
        return taxeRepository.findBySocieteId(societeId).stream()
                .map(taxeMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional
    public TaxeDto create(CreateTaxeRequestDto createTaxeDto) {
        Taxe taxe = taxeMapper.createDtoToEntity(createTaxeDto);
        taxe = taxeRepository.save(taxe);
        return taxeMapper.toDto(taxe);
    }

    @Transactional
    public TaxeDto update(Integer id, TaxeDto taxeDto) {
        return taxeRepository.findById(id)
                .map(existingTaxe -> {
                    Taxe updatedTaxe = taxeMapper.updateEntityFromDto(taxeDto, existingTaxe);
                    updatedTaxe = taxeRepository.save(updatedTaxe);
                    return taxeMapper.toDto(updatedTaxe);
                })
                .orElseThrow(() -> new RuntimeException("Taxe not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        taxeRepository.deleteById(id);
    }
}
