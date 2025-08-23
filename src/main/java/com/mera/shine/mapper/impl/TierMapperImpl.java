package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateTierRequestDto;
import com.mera.shine.dto.response.TierDto;
import com.mera.shine.entity.*;
import com.mera.shine.mapper.TierMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of the TierMapper interface.
 */
@Component
public class TierMapperImpl implements TierMapper {

    @Override
    public TierDto toDto(Tier entity) {
        if (entity == null) {
            return null;
        }

        Integer conditionPaiementId = null;
        if (entity.getConditionPaiement() != null) {
            conditionPaiementId = entity.getConditionPaiement().getId();
        }

        Integer zoneId = null;
        if (entity.getZone() != null) {
            zoneId = entity.getZone().getId();
        }

        Integer taxeId = null;
        if (entity.getTaxe() != null) {
            taxeId = entity.getTaxe().getId();
        }

        Integer groupeId = null;
        if (entity.getGroupe() != null) {
            groupeId = entity.getGroupe().getId();
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        Set<Integer> adresseIds = null;
        if (entity.getAdresses() != null) {
            adresseIds = entity.getAdresses().stream()
                    .map(Adresse::getId)
                    .collect(Collectors.toSet());
        }

        return new TierDto(
                entity.getId(),
                entity.getClCode(),
                entity.getClNom(),
                entity.getClNc(),
                entity.getClRccm(),
                entity.getClTelephone(),
                entity.getClEmail(),
                entity.getClStatutFiscal(),
                entity.getClDescription(),
                entity.getClIsDefaut(),
                entity.getClType(),
                conditionPaiementId,
                zoneId,
                taxeId,
                groupeId,
                societeId,
                adresseIds
        );
    }

    @Override
    public Tier toEntity(TierDto dto) {
        if (dto == null) {
            return null;
        }

        Tier tier = new Tier();
        tier.setId(dto.id());
        tier.setClCode(dto.clCode());
        tier.setClNom(dto.clNom());
        tier.setClNc(dto.clNc());
        tier.setClRccm(dto.clRccm());
        tier.setClTelephone(dto.clTelephone());
        tier.setClEmail(dto.clEmail());
        tier.setClStatutFiscal(dto.clStatutFiscal());
        tier.setClDescription(dto.clDescription());
        tier.setClIsDefaut(dto.clIsDefaut());
        tier.setClType(dto.clType());

        if (dto.conditionPaiementId() != null) {
            LigneConditionPaiement conditionPaiement = new LigneConditionPaiement();
            conditionPaiement.setId(dto.conditionPaiementId());
            tier.setConditionPaiement(conditionPaiement);
        }

        if (dto.zoneId() != null) {
            ZoneDistribution zone = new ZoneDistribution();
            zone.setId(dto.zoneId());
            tier.setZone(zone);
        }

        if (dto.taxeId() != null) {
            Taxe taxe = new Taxe();
            taxe.setId(dto.taxeId());
            tier.setTaxe(taxe);
        }

        if (dto.groupeId() != null) {
            Group groupe = new Group();
            groupe.setId(dto.groupeId());
            tier.setGroupe(groupe);
        }

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            tier.setSociete(societe);
        }

        // We don't set adresses here as it's a one-to-many relationship
        // and would require loading the actual Adresse entities

        return tier;
    }

    @Override
    public Tier createDtoToEntity(CreateTierRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Tier tier = new Tier();
        tier.setClCode(createDto.clCode());
        tier.setClNom(createDto.clNom());
        tier.setClNc(createDto.clNc());
        tier.setClRccm(createDto.clRccm());
        tier.setClTelephone(createDto.clTelephone());
        tier.setClEmail(createDto.clEmail());
        tier.setClStatutFiscal(createDto.clStatutFiscal());
        tier.setClDescription(createDto.clDescription());
        tier.setClIsDefaut(createDto.clIsDefaut());
        tier.setClType(createDto.clType());

        if (createDto.conditionPaiementId() != null) {
            LigneConditionPaiement conditionPaiement = new LigneConditionPaiement();
            conditionPaiement.setId(createDto.conditionPaiementId());
            tier.setConditionPaiement(conditionPaiement);
        }

        if (createDto.zoneId() != null) {
            ZoneDistribution zone = new ZoneDistribution();
            zone.setId(createDto.zoneId());
            tier.setZone(zone);
        }

        if (createDto.taxeId() != null) {
            Taxe taxe = new Taxe();
            taxe.setId(createDto.taxeId());
            tier.setTaxe(taxe);
        }

        if (createDto.groupeId() != null) {
            Group groupe = new Group();
            groupe.setId(createDto.groupeId());
            tier.setGroupe(groupe);
        }

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            tier.setSociete(societe);
        }

        tier.setAdresses(new HashSet<>());

        return tier;
    }

    @Override
    public Tier updateEntityFromDto(TierDto dto, Tier entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setClCode(dto.clCode());
        entity.setClNom(dto.clNom());
        entity.setClNc(dto.clNc());
        entity.setClRccm(dto.clRccm());
        entity.setClTelephone(dto.clTelephone());
        entity.setClEmail(dto.clEmail());
        entity.setClStatutFiscal(dto.clStatutFiscal());
        entity.setClDescription(dto.clDescription());
        entity.setClIsDefaut(dto.clIsDefaut());
        entity.setClType(dto.clType());

        if (dto.conditionPaiementId() != null) {
            if (entity.getConditionPaiement() == null || !entity.getConditionPaiement().getId().equals(dto.conditionPaiementId())) {
                LigneConditionPaiement conditionPaiement = new LigneConditionPaiement();
                conditionPaiement.setId(dto.conditionPaiementId());
                entity.setConditionPaiement(conditionPaiement);
            }
        } else {
            entity.setConditionPaiement(null);
        }

        if (dto.zoneId() != null) {
            if (entity.getZone() == null || !entity.getZone().getId().equals(dto.zoneId())) {
                ZoneDistribution zone = new ZoneDistribution();
                zone.setId(dto.zoneId());
                entity.setZone(zone);
            }
        } else {
            entity.setZone(null);
        }

        if (dto.taxeId() != null) {
            if (entity.getTaxe() == null || !entity.getTaxe().getId().equals(dto.taxeId())) {
                Taxe taxe = new Taxe();
                taxe.setId(dto.taxeId());
                entity.setTaxe(taxe);
            }
        } else {
            entity.setTaxe(null);
        }

        if (dto.groupeId() != null) {
            if (entity.getGroupe() == null || !entity.getGroupe().getId().equals(dto.groupeId())) {
                Group groupe = new Group();
                groupe.setId(dto.groupeId());
                entity.setGroupe(groupe);
            }
        } else {
            entity.setGroupe(null);
        }

        if (dto.societeId() != null) {
            if (entity.getSociete() == null || !entity.getSociete().getId().equals(dto.societeId())) {
                Societe societe = new Societe();
                societe.setId(dto.societeId());
                entity.setSociete(societe);
            }
        } else {
            entity.setSociete(null);
        }

        // We don't update adresses here as it's a one-to-many relationship
        // and would require loading the actual Adresse entities

        return entity;
    }
}