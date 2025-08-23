package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateUniteMesureRequestDto;
import com.mera.shine.dto.response.UniteMesureDto;
import com.mera.shine.entity.Societe;
import com.mera.shine.entity.UniteMesure;
import com.mera.shine.mapper.UniteMesureMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the UniteMesureMapper interface.
 */
@Component
public class UniteMesureMapperImpl implements UniteMesureMapper {

    @Override
    public UniteMesureDto toDto(UniteMesure entity) {
        if (entity == null) {
            return null;
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }

        return new UniteMesureDto(
                entity.getId(),
                entity.getUmCode(),
                entity.getUmLibelle(),
                entity.getUmIsReference(),
                societeId
        );
    }

    @Override
    public UniteMesure toEntity(UniteMesureDto dto) {
        if (dto == null) {
            return null;
        }

        UniteMesure uniteMesure = new UniteMesure();
        uniteMesure.setId(dto.id());
        uniteMesure.setUmCode(dto.umCode());
        uniteMesure.setUmLibelle(dto.umLibelle());
        uniteMesure.setUmIsReference(dto.umIsReference());

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            uniteMesure.setSociete(societe);
        }

        return uniteMesure;
    }

    @Override
    public UniteMesure createDtoToEntity(CreateUniteMesureRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        UniteMesure uniteMesure = new UniteMesure();
        uniteMesure.setUmCode(createDto.umCode());
        uniteMesure.setUmLibelle(createDto.umLibelle());
        uniteMesure.setUmIsReference(createDto.umIsReference());

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            uniteMesure.setSociete(societe);
        }

        return uniteMesure;
    }

    @Override
    public UniteMesure updateEntityFromDto(UniteMesureDto dto, UniteMesure entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setUmCode(dto.umCode());
        entity.setUmLibelle(dto.umLibelle());
        entity.setUmIsReference(dto.umIsReference());

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