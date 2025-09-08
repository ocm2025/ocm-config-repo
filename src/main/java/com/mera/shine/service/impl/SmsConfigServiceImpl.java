package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateSmsConfigRequestDto;
import com.mera.shine.dto.response.SmsConfigDto;
import com.mera.shine.entity.SmsConfig;
import com.mera.shine.mapper.SmsConfigMapper;
import com.mera.shine.repository.SmsConfigRepository;
import com.mera.shine.service.SmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the SmsConfigService interface.
 */
@Service
@Transactional
public class SmsConfigServiceImpl implements SmsConfigService {

    private final SmsConfigRepository smsConfigRepository;
    private final SmsConfigMapper smsConfigMapper;

    @Autowired
    public SmsConfigServiceImpl(SmsConfigRepository smsConfigRepository, SmsConfigMapper smsConfigMapper) {
        this.smsConfigRepository = smsConfigRepository;
        this.smsConfigMapper = smsConfigMapper;
    }

    @Transactional(readOnly = true)
    public List<SmsConfigDto> findAll() {
        return smsConfigRepository.findAll().stream()
                .map(smsConfigMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<SmsConfigDto> findById(Integer id) {
        return smsConfigRepository.findById(id)
                .map(smsConfigMapper::toDto);
    }

    @Transactional(readOnly = true)
    public List<SmsConfigDto> findBySocieteId(Integer societeId) {
        return smsConfigRepository.findBySocieteId(societeId).stream()
                .map(smsConfigMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public SmsConfigDto create(CreateSmsConfigRequestDto createSmsConfigDto) {
        SmsConfig smsConfig = smsConfigMapper.createDtoToEntity(createSmsConfigDto);
        smsConfig = smsConfigRepository.save(smsConfig);
        return smsConfigMapper.toDto(smsConfig);
    }

    @Transactional
    public SmsConfigDto update(Integer id, SmsConfigDto smsConfigDto) {
        return smsConfigRepository.findById(id)
                .map(existingSmsConfig -> {
                    SmsConfig updatedSmsConfig = smsConfigMapper.updateEntityFromDto(smsConfigDto, existingSmsConfig);
                    updatedSmsConfig = smsConfigRepository.save(updatedSmsConfig);
                    return smsConfigMapper.toDto(updatedSmsConfig);
                })
                .orElseThrow(() -> new RuntimeException("SmsConfig not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        smsConfigRepository.deleteById(id);
    }
}
