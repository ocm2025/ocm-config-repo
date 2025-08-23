package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateModePaiementRequestDto;
import com.mera.shine.dto.response.ModePaiementDto;
import com.mera.shine.entity.ModePaiement;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.ModePaiementMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the ModePaiementMapper interface.
 */
@Component
public class ModePaiementMapperImpl implements ModePaiementMapper {

    @Override
    public ModePaiementDto toDto(ModePaiement entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        return new ModePaiementDto(
                entity.getId(),
                entity.getMpNom(),
                entity.getMpVirgule(),
                societeId
        );
    }

    @Override
    public ModePaiement toEntity(ModePaiementDto dto) {
        if (dto == null) {
            return null;
        }

        ModePaiement modePaiement = new ModePaiement();
        modePaiement.setId(dto.id());
        modePaiement.setMpNom(dto.mpNom());
        modePaiement.setMpVirgule(dto.mpVirgule());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            modePaiement.setSociete(societe);
        }

        return modePaiement;
    }

    @Override
    public ModePaiement createDtoToEntity(CreateModePaiementRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        ModePaiement modePaiement = new ModePaiement();
        modePaiement.setMpNom(createDto.mpNom());
        modePaiement.setMpVirgule(createDto.mpVirgule());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            modePaiement.setSociete(societe);
        }

        return modePaiement;
    }

    @Override
    public ModePaiement updateEntityFromDto(ModePaiementDto dto, ModePaiement entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setMpNom(dto.mpNom());
        entity.setMpVirgule(dto.mpVirgule());

        if (dto.societeId() != null) {
            if (entity.getSociete() == null || !entity.getSociete().getId().equals(dto.societeId())) {
                Societe societe = new Societe();
                societe.setId(dto.societeId());
                entity.setSociete(societe);
            }
        } else {
            entity.setSociete(null);
        }

        return entity;
    }
}