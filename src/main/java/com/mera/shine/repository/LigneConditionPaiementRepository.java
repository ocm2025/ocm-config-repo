package com.mera.shine.repository;

import com.mera.shine.entity.LigneConditionPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the LigneConditionPaiement entity.
 */
@Repository
public interface LigneConditionPaiementRepository extends JpaRepository<LigneConditionPaiement, Integer> {

    List<LigneConditionPaiement> findBySocieteId(Integer societeId);
}