package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateTaxeRequestDto;
import com.mera.shine.dto.response.TaxeDto;
import com.mera.shine.entity.Societe;
import com.mera.shine.entity.Taxe;
import com.mera.shine.mapper.TaxeMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the TaxeMapper interface.
 */
@Component
public class TaxeMapperImpl implements TaxeMapper {

    @Override
    public TaxeDto toDto(Taxe entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        return new TaxeDto(
                entity.getId(),
                entity.getTaxNom(),
                entity.getType(),
                entity.getTaxValeur(),
                entity.getTaxNature(),
                entity.getTaxIsRetenue(),
                societeId
        );
    }

    @Override
    public Taxe toEntity(TaxeDto dto) {
        if (dto == null) {
            return null;
        }

        Taxe taxe = new Taxe();
        taxe.setId(dto.id());
        taxe.setTaxNom(dto.taxNom());
        taxe.setType(dto.type());
        taxe.setTaxValeur(dto.taxValeur());
        taxe.setTaxNature(dto.taxNature());
        taxe.setTaxIsRetenue(dto.taxIsRetenue());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            taxe.setSociete(societe);
        }

        return taxe;
    }

    @Override
    public Taxe createDtoToEntity(CreateTaxeRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Taxe taxe = new Taxe();
        taxe.setTaxNom(createDto.taxNom());
        taxe.setType(createDto.type());
        taxe.setTaxValeur(createDto.taxValeur());
        taxe.setTaxNature(createDto.taxNature());
        taxe.setTaxIsRetenue(createDto.taxIsRetenue());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            taxe.setSociete(societe);
        }

        return taxe;
    }

    @Override
    public Taxe updateEntityFromDto(TaxeDto dto, Taxe entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setTaxNom(dto.taxNom());
        entity.setType(dto.type());
        entity.setTaxValeur(dto.taxValeur());
        entity.setTaxNature(dto.taxNature());
        entity.setTaxIsRetenue(dto.taxIsRetenue());

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