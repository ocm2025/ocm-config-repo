package com.mera.shine.service.impl;

import com.mera.shine.dto.request.CreateUtilisateurRequestDto;
import com.mera.shine.dto.response.UtilisateurDto;
import com.mera.shine.entity.Utilisateur;
import com.mera.shine.mapper.UtilisateurMapper;
import com.mera.shine.repository.UtilisateurRepository;
import com.mera.shine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of the UtilisateurService interface.
 */
@Service
@Transactional
public  class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UtilisateurDto> findById(Integer id) {
        return utilisateurRepository.findById(id)
                .map(utilisateurMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UtilisateurDto> findBySocieteId(Integer societeId) {
        return utilisateurRepository.findBysocieteId(societeId).stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UtilisateurDto> findBySiteId(Integer siteId) {
        return utilisateurRepository.findBySiteId(siteId).stream()
                .map(utilisateurMapper::toDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public UtilisateurDto create(CreateUtilisateurRequestDto createUtilisateurDto) {
        Utilisateur utilisateur = utilisateurMapper.createDtoToEntity(createUtilisateurDto);
        // Hash the password before saving
        utilisateur.setUPassword(passwordEncoder.encode(utilisateur.getUPassword()));
        // Store the original password in uPwdText if needed
        if (utilisateur.getUPwdText() == null) {
            utilisateur.setUPwdText(createUtilisateurDto.uPassword());
        }
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDto(utilisateur);
    }

    @Override
    @Transactional
    public UtilisateurDto update(Integer id, UtilisateurDto utilisateurDto) {
        return utilisateurRepository.findById(id)
                .map(existingUtilisateur -> {
                    Utilisateur updatedUtilisateur = utilisateurMapper.updateEntityFromDto(utilisateurDto, existingUtilisateur);
                   if (updatedUtilisateur.getUPassword() != null && !updatedUtilisateur.getUPassword().isEmpty()) {
                       updatedUtilisateur.setUPassword(passwordEncoder.encode(updatedUtilisateur.getUPassword()));
                   }
                    updatedUtilisateur = utilisateurRepository.save(updatedUtilisateur);
                    return utilisateurMapper.toDto(updatedUtilisateur);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur not found with id: " + id));
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        utilisateurRepository.deleteById(id);
    }


}
