package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateAdresseRequestDto;
import com.mera.shine.dto.response.AdresseDto;
import com.mera.shine.entity.Adresse;
import com.mera.shine.entity.Tier;
import com.mera.shine.mapper.AdresseMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the AdresseMapper interface.
 */
@Component
public class AdresseMapperImpl implements AdresseMapper {

    @Override
    public AdresseDto toDto(Adresse entity) {
        if (entity == null) {
            return null;
        }

        Integer tiersId = null;
        if (entity.getTiers() != null) {
            tiersId = entity.getTiers().getId();
        }

        return new AdresseDto(
                entity.getId(),
                entity.getAfType(),
                entity.getAfRue(),
                entity.getAfVille(),
                entity.getAfPays(),
                entity.getAfCodePostal(),
                tiersId
        );
    }

    @Override
    public Adresse toEntity(AdresseDto dto) {
        if (dto == null) {
            return null;
        }

        Adresse adresse = new Adresse();
        adresse.setId(dto.id());
        adresse.setAfType(dto.afType());
        adresse.setAfRue(dto.afRue());
        adresse.setAfVille(dto.afVille());
        adresse.setAfPays(dto.afPays());
        adresse.setAfCodePostal(dto.afCodePostal());

        if (dto.tiersId() != null) {
            Tier tier = new Tier();
            tier.setId(dto.tiersId());
            adresse.setTiers(tier);
        }

        return adresse;
    }

    @Override
    public Adresse createDtoToEntity(CreateAdresseRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Adresse adresse = new Adresse();
        adresse.setAfType(createDto.afType());
        adresse.setAfRue(createDto.afRue());
        adresse.setAfVille(createDto.afVille());
        adresse.setAfPays(createDto.afPays());
        adresse.setAfCodePostal(createDto.afCodePostal());

        if (createDto.tiersId() != null) {
            Tier tier = new Tier();
            tier.setId(createDto.tiersId());
            adresse.setTiers(tier);
        }

        return adresse;
    }

    @Override
    public Adresse updateEntityFromDto(AdresseDto dto, Adresse entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setAfType(dto.afType());
        entity.setAfRue(dto.afRue());
        entity.setAfVille(dto.afVille());
        entity.setAfPays(dto.afPays());
        entity.setAfCodePostal(dto.afCodePostal());

        if (dto.tiersId() != null) {
            if (entity.getTiers() == null || !entity.getTiers().getId().equals(dto.tiersId())) {
                Tier tier = new Tier();
                tier.setId(dto.tiersId());
                entity.setTiers(tier);
            }
        } else {
            entity.setTiers(null);
        }

        return entity;
    }
}