package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateLigneConditionPaiementRequestDto;
import com.mera.shine.dto.response.LigneConditionPaiementDto;
import com.mera.shine.entity.ItemsConditionPaiement;
import com.mera.shine.entity.LigneConditionPaiement;
import com.mera.shine.entity.Societe;
import com.mera.shine.mapper.LigneConditionPaiementMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the LigneConditionPaiementMapper interface.
 */
@Component
public class LigneConditionPaiementMapperImpl implements LigneConditionPaiementMapper {

    @Override
    public LigneConditionPaiementDto toDto(LigneConditionPaiement entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        Set<Integer> itemsConditionPaiementIds = null;
        if (entity.getItemsConditionPaiements() != null) {
            itemsConditionPaiementIds = entity.getItemsConditionPaiements().stream()
                    .map(ItemsConditionPaiement::getId)
                    .collect(Collectors.toSet());
        }

        return new LigneConditionPaiementDto(
                entity.getId(),
                entity.getLcpNom(),
                entity.getLcpDescription(),
                societeId,
                itemsConditionPaiementIds
        );
    }

    @Override
    public LigneConditionPaiement toEntity(LigneConditionPaiementDto dto) {
        if (dto == null) {
            return null;
        }

        LigneConditionPaiement ligneConditionPaiement = new LigneConditionPaiement();
        ligneConditionPaiement.setId(dto.id());
        ligneConditionPaiement.setLcpNom(dto.lcpNom());
        ligneConditionPaiement.setLcpDescription(dto.lcpDescription());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            ligneConditionPaiement.setSociete(societe);
        }

        // We don't set itemsConditionPaiements here as it's a one-to-many relationship
        // and would require loading the actual ItemsConditionPaiement entities

        return ligneConditionPaiement;
    }

    @Override
    public LigneConditionPaiement createDtoToEntity(CreateLigneConditionPaiementRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        LigneConditionPaiement ligneConditionPaiement = new LigneConditionPaiement();
        ligneConditionPaiement.setLcpNom(createDto.lcpNom());
        ligneConditionPaiement.setLcpDescription(createDto.lcpDescription());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            ligneConditionPaiement.setSociete(societe);
        }

        ligneConditionPaiement.setItemsConditionPaiements(new HashSet<>());

        return ligneConditionPaiement;
    }

    @Override
    public LigneConditionPaiement updateEntityFromDto(LigneConditionPaiementDto dto, LigneConditionPaiement entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setLcpNom(dto.lcpNom());
        entity.setLcpDescription(dto.lcpDescription());

        if (dto.societeId() != null) {
            if (entity.getSociete() == null || !entity.getSociete().getId().equals(dto.societeId())) {
                Societe societe = new Societe();
                societe.setId(dto.societeId());
                entity.setSociete(societe);
            }
        } else {
            entity.setSociete(null);
        }

        // We don't update itemsConditionPaiements here as it's a one-to-many relationship
        // and would require loading the actual ItemsConditionPaiement entities

        return entity;
    }
}