package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateItemsConditionPaiementRequestDto;
import com.mera.shine.dto.response.ItemsConditionPaiementDto;
import com.mera.shine.entity.ItemsConditionPaiement;
import com.mera.shine.entity.LigneConditionPaiement;
import com.mera.shine.mapper.ItemsConditionPaiementMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the ItemsConditionPaiementMapper interface.
 */
@Component
public class ItemsConditionPaiementMapperImpl implements ItemsConditionPaiementMapper {

    @Override
    public ItemsConditionPaiementDto toDto(ItemsConditionPaiement entity) {
        if (entity == null) {
            return null;
        }

        Integer conditionPaiementId = null;
        if (entity.getConditionPaiement() != null) {
            conditionPaiementId = entity.getConditionPaiement().getId();
        }

        return new ItemsConditionPaiementDto(
                entity.getId(),
                entity.getIcpTypeEcheance(),
                entity.getCpiValeur(),
                entity.getIcpDelais(),
                conditionPaiementId
        );
    }

    @Override
    public ItemsConditionPaiement toEntity(ItemsConditionPaiementDto dto) {
        if (dto == null) {
            return null;
        }

        ItemsConditionPaiement itemsConditionPaiement = new ItemsConditionPaiement();
        itemsConditionPaiement.setId(dto.id());
        itemsConditionPaiement.setIcpTypeEcheance(dto.icpTypeEcheance());
        itemsConditionPaiement.setCpiValeur(dto.cpiValeur());
        itemsConditionPaiement.setIcpDelais(dto.icpDelais());

        if (dto.conditionPaiementId() != null) {
            LigneConditionPaiement ligneConditionPaiement = new LigneConditionPaiement();
            ligneConditionPaiement.setId(dto.conditionPaiementId());
            itemsConditionPaiement.setConditionPaiement(ligneConditionPaiement);
        }

        return itemsConditionPaiement;
    }

    @Override
    public ItemsConditionPaiement createDtoToEntity(CreateItemsConditionPaiementRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        ItemsConditionPaiement itemsConditionPaiement = new ItemsConditionPaiement();
        itemsConditionPaiement.setIcpTypeEcheance(createDto.icpTypeEcheance());
        itemsConditionPaiement.setCpiValeur(createDto.cpiValeur());
        itemsConditionPaiement.setIcpDelais(createDto.icpDelais());

        if (createDto.conditionPaiementId() != null) {
            LigneConditionPaiement ligneConditionPaiement = new LigneConditionPaiement();
            ligneConditionPaiement.setId(createDto.conditionPaiementId());
            itemsConditionPaiement.setConditionPaiement(ligneConditionPaiement);
        }

        return itemsConditionPaiement;
    }

    @Override
    public ItemsConditionPaiement updateEntityFromDto(ItemsConditionPaiementDto dto, ItemsConditionPaiement entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setIcpTypeEcheance(dto.icpTypeEcheance());
        entity.setCpiValeur(dto.cpiValeur());
        entity.setIcpDelais(dto.icpDelais());

        if (dto.conditionPaiementId() != null) {
            if (entity.getConditionPaiement() == null || !entity.getConditionPaiement().getId().equals(dto.conditionPaiementId())) {
                LigneConditionPaiement ligneConditionPaiement = new LigneConditionPaiement();
                ligneConditionPaiement.setId(dto.conditionPaiementId());
                entity.setConditionPaiement(ligneConditionPaiement);
            }
        } else {
            entity.setConditionPaiement(null);
        }

        return entity;
    }
}