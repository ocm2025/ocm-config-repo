package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateOptionsSysRequestDto;
import com.mera.shine.dto.response.OptionsSysDto;
import com.mera.shine.entity.OptionsSys;
import com.mera.shine.mapper.OptionsSysMapper;
import com.mera.shine.repository.OptionsSysRepository;
import com.mera.shine.service.OptionsSysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the OptionsSysService interface.
 */
@Service
@Transactional
public class OptionsSysServiceImpl implements OptionsSysService {

    private final OptionsSysRepository optionsSysRepository;
    private final OptionsSysMapper optionsSysMapper;

    @Autowired
    public OptionsSysServiceImpl(OptionsSysRepository optionsSysRepository, OptionsSysMapper optionsSysMapper) {
        this.optionsSysRepository = optionsSysRepository;
        this.optionsSysMapper = optionsSysMapper;
    }

    @Transactional(readOnly = true)
    public List<OptionsSysDto> findAll() {
        return optionsSysRepository.findAll().stream()
                .map(optionsSysMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<OptionsSysDto> findById(Integer id) {
        return optionsSysRepository.findById(id)
                .map(optionsSysMapper::toDto);
    }

    @Transactional
    public OptionsSysDto create(CreateOptionsSysRequestDto createOptionsSysDto) {
        OptionsSys optionsSys = optionsSysMapper.createDtoToEntity(createOptionsSysDto);
        optionsSys = optionsSysRepository.save(optionsSys);
        return optionsSysMapper.toDto(optionsSys);
    }

    @Transactional
    public OptionsSysDto update(Integer id, OptionsSysDto optionsSysDto) {
        return optionsSysRepository.findById(id)
                .map(existingOptionsSys -> {
                    OptionsSys updatedOptionsSys = optionsSysMapper.updateEntityFromDto(optionsSysDto, existingOptionsSys);
                    updatedOptionsSys = optionsSysRepository.save(updatedOptionsSys);
                    return optionsSysMapper.toDto(updatedOptionsSys);
                })
                .orElseThrow(() -> new RuntimeException("OptionsSys not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        optionsSysRepository.deleteById(id);
    }
}