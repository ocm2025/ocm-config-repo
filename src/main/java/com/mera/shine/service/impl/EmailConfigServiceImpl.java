package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateEmailConfigRequestDto;
import com.mera.shine.dto.response.EmailConfigDto;
import com.mera.shine.entity.EmailConfig;
import com.mera.shine.mapper.EmailConfigMapper;
import com.mera.shine.repository.EmailConfigRepository;
import com.mera.shine.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the EmailConfigService interface.
 */
@Service
@Transactional
public class EmailConfigServiceImpl implements EmailConfigService {

    private final EmailConfigRepository emailConfigRepository;
    private final EmailConfigMapper emailConfigMapper;

    @Autowired
    public EmailConfigServiceImpl(EmailConfigRepository emailConfigRepository, EmailConfigMapper emailConfigMapper) {
        this.emailConfigRepository = emailConfigRepository;
        this.emailConfigMapper = emailConfigMapper;
    }

    @Transactional(readOnly = true)
    public List<EmailConfigDto> findAll() {
        return emailConfigRepository.findAll().stream()
                .map(emailConfigMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<EmailConfigDto> findById(Integer id) {
        return emailConfigRepository.findById(id)
                .map(emailConfigMapper::toDto);
    }

    @Transactional
    public EmailConfigDto create(CreateEmailConfigRequestDto createEmailConfigDto) {
        EmailConfig emailConfig = emailConfigMapper.createDtoToEntity(createEmailConfigDto);
        emailConfig = emailConfigRepository.save(emailConfig);
        return emailConfigMapper.toDto(emailConfig);
    }

    @Transactional
    public EmailConfigDto update(Integer id, EmailConfigDto emailConfigDto) {
        return emailConfigRepository.findById(id)
                .map(existingEmailConfig -> {
                    EmailConfig updatedEmailConfig = emailConfigMapper.updateEntityFromDto(emailConfigDto, existingEmailConfig);
                    updatedEmailConfig = emailConfigRepository.save(updatedEmailConfig);
                    return emailConfigMapper.toDto(updatedEmailConfig);
                })
                .orElseThrow(() -> new RuntimeException("EmailConfig not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        emailConfigRepository.deleteById(id);
    }
}