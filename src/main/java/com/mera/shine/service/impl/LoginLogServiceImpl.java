package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateLoginLogRequestDto;
import com.mera.shine.dto.response.LoginLogDto;
import com.mera.shine.entity.LoginLog;
import com.mera.shine.mapper.LoginLogMapper;
import com.mera.shine.repository.LoginLogRepository;
import com.mera.shine.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the LoginLogService interface.
 */
@Service
@Transactional
public class LoginLogServiceImpl implements LoginLogService {

    private final LoginLogRepository loginLogRepository;
    private final LoginLogMapper loginLogMapper;

    @Autowired
    public LoginLogServiceImpl(LoginLogRepository loginLogRepository, LoginLogMapper loginLogMapper) {
        this.loginLogRepository = loginLogRepository;
        this.loginLogMapper = loginLogMapper;
    }

    @Transactional(readOnly = true)
    public List<LoginLogDto> findAll() {
        return loginLogRepository.findAll().stream()
                .map(loginLogMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<LoginLogDto> findById(Integer id) {
        return loginLogRepository.findById(id)
                .map(loginLogMapper::toDto);
    }

    @Transactional
    public LoginLogDto create(CreateLoginLogRequestDto createLoginLogDto) {
        LoginLog loginLog = loginLogMapper.createDtoToEntity(createLoginLogDto);
        loginLog = loginLogRepository.save(loginLog);
        return loginLogMapper.toDto(loginLog);
    }

    @Transactional
    public LoginLogDto update(Integer id, LoginLogDto loginLogDto) {
        return loginLogRepository.findById(id)
                .map(existingLoginLog -> {
                    LoginLog updatedLoginLog = loginLogMapper.updateEntityFromDto(loginLogDto, existingLoginLog);
                    updatedLoginLog = loginLogRepository.save(updatedLoginLog);
                    return loginLogMapper.toDto(updatedLoginLog);
                })
                .orElseThrow(() -> new RuntimeException("LoginLog not found with id: " + id));
    }

    @Transactional
    public void delete(Integer id) {
        loginLogRepository.deleteById(id);
    }
}
