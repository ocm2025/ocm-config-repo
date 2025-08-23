package com.mera.shine.mapper.impl;

import com.mera.shine.dto.request.CreateUtilisateurRequestDto;
import com.mera.shine.dto.response.UtilisateurDto;
import com.mera.shine.entity.Group;
import com.mera.shine.entity.Site;
import com.mera.shine.entity.Societe;
import com.mera.shine.entity.Utilisateur;
import com.mera.shine.mapper.UtilisateurMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of the UtilisateurMapper interface.
 */
@Component
public class UtilisateurMapperImpl implements UtilisateurMapper {

    @Override
    public UtilisateurDto toDto(Utilisateur entity) {
        if (entity == null) {
            return null;
        }

        Integer siteId = null;
        if (entity.getSite() != null) {
            siteId = entity.getSite().getId();
        }

        Integer societeId = null;
        if (entity.getSociete() != null) {
            societeId = entity.getSociete().getId();
        }
        Integer groupeId = null;
        if (entity.getGroupe() != null) {
            groupeId = entity.getGroupe().getId();
        }

        return new UtilisateurDto(
                entity.getId(),
                entity.getUNomPrenom(),
                entity.getUTelephone(),
                entity.getUAdresse(),
                entity.getUUserName(),
                entity.getUEmail(),
                siteId,
                societeId,
                groupeId
        );
    }

    @Override
    public Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.id());
        utilisateur.setUNomPrenom(dto.uNomPrenom());
        utilisateur.setUTelephone(dto.uTelephone());
        utilisateur.setUAdresse(dto.uAdresse());
        utilisateur.setUUserName(dto.uUserName());
        utilisateur.setUEmail(dto.uEmail());

        // Note: Password fields are not included in the DTO for security reasons
        // They should be set separately when needed

        if (dto.siteId() != null) {
            Site site = new Site();
            site.setId(dto.siteId());
            utilisateur.setSite(site);
        }

        if (dto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(dto.societeId());
            utilisateur.setSociete(societe);
        }

        if (dto.groupeId() != null) {
            Group groupe = new Group();
            groupe.setId(dto.groupeId());
            utilisateur.setGroupe(groupe);
        }

        return utilisateur;
    }

    @Override
    public Utilisateur createDtoToEntity(CreateUtilisateurRequestDto createDto) {
        if (createDto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUNomPrenom(createDto.uNomPrenom());
        utilisateur.setUTelephone(createDto.uTelephone());
        utilisateur.setUAdresse(createDto.uAdresse());
        utilisateur.setUUserName(createDto.uUserName());
        utilisateur.setUPassword(createDto.uPassword());
        utilisateur.setUEmail(createDto.uEmail());
        utilisateur.setUPwdText(createDto.uPwdText());

        if (createDto.siteId() != null) {
            Site site = new Site();
            site.setId(createDto.siteId());
            utilisateur.setSite(site);
        }

        if (createDto.societeId() != null) {
            Societe societe = new Societe();
            societe.setId(createDto.societeId());
            utilisateur.setSociete(societe);
        }

        if (createDto.groupeId() != null) {
            Group groupe = new Group();
            groupe.setId(createDto.siteId());
            utilisateur.setGroupe(groupe);
        }

        return utilisateur;
    }

    @Override
    public Utilisateur updateEntityFromDto(UtilisateurDto dto, Utilisateur entity) {
        if (dto == null || entity == null) {
            return entity;
        }

        entity.setUNomPrenom(dto.uNomPrenom());
        entity.setUTelephone(dto.uTelephone());
        entity.setUAdresse(dto.uAdresse());
        entity.setUUserName(dto.uUserName());
        entity.setUEmail(dto.uEmail());

        // Note: Password fields are not included in the DTO for security reasons
        // They should be updated separately when needed

        if (dto.siteId() != null) {
            if (entity.getSite() == null || !entity.getSite().getId().equals(dto.siteId())) {
                Site site = new Site();
                site.setId(dto.siteId());
                entity.setSite(site);
            }
        } else {
            entity.setSite(null);
        }

        if (dto.groupeId() != null) {
            if (entity.getGroupe() == null || !entity.getGroupe().getId().equals(dto.groupeId())) {
                Group group = new Group();
                group.setId(dto.groupeId());
                entity.setGroupe(group);
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

        return entity;
    }
}