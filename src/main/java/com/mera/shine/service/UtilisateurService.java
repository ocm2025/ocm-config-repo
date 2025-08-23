package com.mera.shine.service;

import com.mera.shine.dto.request.CreateUtilisateurRequestDto;
import com.mera.shine.dto.response.UtilisateurDto;
import com.mera.shine.entity.Utilisateur;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Utilisateur entities.
 */
public interface UtilisateurService {
    
    /**
     * Get all utilisateurs.
     *
     * @return list of all utilisateurs
     */
    List<UtilisateurDto> findAll();

    /**
     * Get an utilisateur by its ID.
     *
     * @param id the ID of the utilisateur
     * @return the utilisateur if found
     */
    Optional<UtilisateurDto> findById(Integer id);

    /**
     * Create a new utilisateur.
     *
     * @param createUtilisateurDto the utilisateur to create
     * @return the created utilisateur
     */
    UtilisateurDto create(CreateUtilisateurRequestDto createUtilisateurDto);
    
    /**
     * Update an existing utilisateur.
     *
     * @param id the ID of the utilisateur to update
     * @param utilisateurDto the updated utilisateur data
     * @return the updated utilisateur
     */
    UtilisateurDto update(Integer id, UtilisateurDto utilisateurDto);

    /**
     * Delete an utilisateur by its ID.
     *
     * @param id the ID of the utilisateur to delete
     */
    void delete(Integer id);

}